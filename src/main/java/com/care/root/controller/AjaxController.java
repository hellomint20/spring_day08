package com.care.root.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.dto.InfoDTO;

@Controller
public class AjaxController {
	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non ajax");
		return "ajax/non_ajax";
	}
	@GetMapping("ajax01")
	public String ajax01() {
		System.out.println("ajax01");
		return "ajax/ajax01";
	}
	@GetMapping("ajax02")
	public String ajax02() {
		System.out.println("ajax02");
		return "ajax/ajax02";
	}
	int cnt = 0;
	@GetMapping("result02")
	@ResponseBody //return���� ������ ������
	public String result02() {
		System.out.println("result02");
		return "" + cnt++ ;
	}
	@GetMapping("ajax03")
	public String ajax03() {
		System.out.println("ajax03");
		return "ajax/ajax03";
	}
												//�޴� ������ Ÿ��
	@PostMapping(value = "result03", produces = "application/json; charset=utf-8")
	@ResponseBody 
	public InfoDTO result03(@RequestBody InfoDTO dto) {
		System.out.println("result03");
		System.out.println("�̸� : "+dto.getName());
		System.out.println("���� : "+dto.getAge());
		
		dto.setName("���� ���� �̸�");
		dto.setAge(111);
		
		return dto;
	}
	@GetMapping("ajax04")
	public String ajax04() {
		System.out.println("ajax04");
		return "ajax/ajax04";
	}
												//�޴� ������ Ÿ��
	@PostMapping(value = "result04", produces = "application/json; charset=utf-8")
	@ResponseBody 
	public Map<String, String> result04(@RequestBody Map<String, String> map) {
		System.out.println("result04");
		System.out.println(map);
		System.out.println(map.get("name"));
		
		map.put("nick", "�����"); //map�� nick �߰�
		return map;
	}
	@GetMapping("rest01")
	public String rest01() {
		return "ajax/rest01";
	}
	@GetMapping("member")
	public String member() {
		return "ajax/member";
	}
}
