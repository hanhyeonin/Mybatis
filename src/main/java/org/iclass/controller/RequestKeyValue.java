package org.iclass.controller;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode			// 필수 (리턴 mapping.get 하려면 꼭 필요함.) - RequestControllerMapping.java 에 있음.
public class RequestKeyValue {
	private String url;			// servlet Path
	private String method;		// get, post 저장
}
