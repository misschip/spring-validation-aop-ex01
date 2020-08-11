package com.cos.validex01.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import com.cos.validex01.RespDto;
import com.cos.validex01.StatusCode;

//공통관심사 : advice
@Component
@Aspect	// AOP 등록완료
public class BindingAdvice {
	
	
	@Before("execution(* com.cos.validex01.test.BindControllerTest.*(..))")
	public void test1() {
		System.out.println("BindControllerTest에 오신 것을 환영합니다. Before");
	}
	
	@After("execution(* com.cos.validex01.test.BindControllerTest.*(..))")
	public void test2() {
		System.out.println("BindControllerTest에 오신 것을 환영합니다. After");
	}
	

	// @Before, @After, @Around
	// 뒷부분은 정규표현식이 들어감 ..은 0개 이상 의미
	// execution(* 에서 *은 리턴 타입 의미
	@Around("execution(* com.cos.validex01..*Controller.*(..))")
	public Object validationHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		System.out.println("type:" + type);
		System.out.println("method:" + method);
		
		Object[] args = proceedingJoinPoint.getArgs();	// 조인 포인트의 파라메터
		
		for(Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				
				if (bindingResult.hasErrors()) {
					System.out.println(bindingResult.getFieldError());
					Map<String,String> errorMap = new HashMap<>();
					
					for (FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					
					RespDto<?> respDto = RespDto.builder()
							.statusCode(StatusCode.FAIL)
							.msg("save 요청에 실패하였습니다")
							.data(errorMap)
							.build();
					
					return new ResponseEntity<RespDto>(respDto, HttpStatus.BAD_REQUEST);
				}

			}
		}
		
		return proceedingJoinPoint.proceed();
	}
}
