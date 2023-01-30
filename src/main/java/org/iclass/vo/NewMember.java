package org.iclass.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NewMember {
	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	private String gender;
	private String hobbies;		// 취미를 , 로 나열해서 저장.
	private LocalDateTime joinDate;
	private Timestamp joinDate2;
	
	//java.sql.Timestamp  타입을 LocalDateTime 타입으로 변경해서 리턴하는 명령(필요시 사용)
		public LocalDateTime timestampToLocalDateTime() {
			joinDate = joinDate2.toLocalDateTime();
			return joinDate;
		}
		
		// LocalDateTime 타입을 java.sql.Timestamp 타입으로 변경하고 리턴하는 명령(필요시 사용)
		public Timestamp localDateTimeToTimestamp() {
			joinDate2 = Timestamp.valueOf(joinDate) ;
			return joinDate2;
		}
}
