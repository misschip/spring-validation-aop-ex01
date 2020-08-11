package com.cos.validex01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data	// 업무 할 때는 model에는 setter가 있으면 안됨. 데이터 불변성
public class ProjectTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=10, message = "Summary cannot exceed 10")	// 사실 이런 제약조건 관련은 회사에 가면 Dto 객체에 다 어노테이션으로 넣어야 함
	@NotBlank(message = "Summary cannot be blank")		// model은 DB에 넣는 용도임
	private String summary;
	@NotBlank(message = "acceptanceCriteria cannot be blank")
	private String acceptanceCriteria;
	private String status;
	@Email(message = "Your email xxx")
	private String email;
}