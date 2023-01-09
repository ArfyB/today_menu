package com.today.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data //get set
@ToString
//@EqualsAndHashCode(exclude = {"ename","deptno","sal","hiredate"})
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable
{
	private String id;
	private String userpassword;
	private String userphone;
	private String useremail;
}
