package com.biz.ajax0001.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptVO implements Serializable{

	private String d_code ;
	private String d_name;
	private String d_ceo;
	
}