package com.cos.validex01;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RespDto<T> {
	private int statusCode;	// 1,2,3,4,5... (인터페이스로 코드값 지정)
	private String msg;
	
	private T data;	// body로 명명해도 좋음
}
// statusCode 보고 성공이면 data 읽어오면 되고
// 실패면 msg를 읽어보면 실패의 이유가 나오는 식으로