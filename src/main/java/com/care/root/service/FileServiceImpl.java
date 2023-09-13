package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper mapper;
	
	public void fileProcess(String id, String name, MultipartFile file) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		//파일 전송 유무
		if(!file.isEmpty()) { //file.getSize() != 0 : 파일이 존재함
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileName : "+sysFileName);
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
									//이 위치에 이런 이름으로 저장할 거임
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		try {
			mapper.saveData(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<FileDTO> getData(){
		List<FileDTO> list = null;
		try {
			list = mapper.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void delete(String file, String id) {
		try {
			int result = mapper.delete(id);
			if(result == 1) { //DB에서 삭제 되면
				File d = new File(IMAGE_REPO+"/"+file);
				if( d.exists() ) { //파일이 존재한다면 삭제
					d.delete();
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public FileDTO getInfo(String id) {
		FileDTO dto = null;
		try {
			dto = mapper.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void modify(String id, String name, MultipartFile file) {
		try {
			String fileName = mapper.getInfo(id).getImgName();
			File d = new File(IMAGE_REPO+"/"+fileName);
			if( d.exists() ) { //파일이 존재한다면 삭제
				d.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		//파일 전송 유무
		if(!file.isEmpty()) { //file.getSize() != 0 : 파일이 존재함
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
									//이 위치에 이런 이름으로 저장할 거임
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		try {
			mapper.modify(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
