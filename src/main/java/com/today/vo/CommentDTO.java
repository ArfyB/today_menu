package com.today.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDTO 
{
	private String email;
	private String num;
	private String content;
	private java.sql.Timestamp COM_CREATEDDATE;
    private java.sql.Timestamp updatedDate;
    
}
