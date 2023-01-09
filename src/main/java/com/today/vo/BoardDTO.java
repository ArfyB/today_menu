package com.today.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude={"title","contents","author","createdDate","updatedDate","hitcnt"})
public class BoardDTO implements Serializable 
{
	private int num;
	private String title;
	private String contents;
	private String author;
    private java.sql.Timestamp createdDate;
    private java.sql.Timestamp updatedDate;
	private int hitcnt;
	private int cnt;
	private List<Attach> attList = new ArrayList<>();
	
	public BoardDTO(int num)
	{
		this.num = num;
	}
}
