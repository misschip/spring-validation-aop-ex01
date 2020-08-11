package com.cos.validex01;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/board")
public class ProjectTaskController {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	@PostMapping({"","/"})
	public ResponseEntity<?> save(@Valid @RequestBody ProjectTask requestProjectTask, BindingResult bindingResult) {
		
//		
//		
//		if (bindingResult.hasErrors()) {
//			System.out.println(bindingResult.getFieldError());
//			Map<String,String> errorMap = new HashMap<>();
//			
//			for (FieldError error : bindingResult.getFieldErrors()) {
//				errorMap.put(error.getField(), error.getDefaultMessage());
//			}
//			
//			RespDto<?> respDto = RespDto.builder()
//					.statusCode(StatusCode.FAIL)
//					.msg("save 요청에 실패하였습니다")
//					.data(errorMap)
//					.build();
//			
//			return new ResponseEntity<RespDto>(respDto, HttpStatus.BAD_REQUEST);
//		}
		
		ProjectTask entityProjectTask = projectTaskRepository.save(requestProjectTask);
		
//		RespDto<?> respDto = RespDto.builder()
//				.statusCode(StatusCode.OK)
//				.msg("save 요청에 성공하였습니다")
//				.data(entityProjectTask)
//				.build();
			
		return new ResponseEntity<ProjectTask>(entityProjectTask, HttpStatus.CREATED);
	}
}


/* 프론트, 백엔드, 안드로이드 개발자 간 약속(프로토콜)
1: 정상
2: 아이디 중복
3: ...
4: ...
*/