package com.faqs.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.faqs.eneity.Classes;
import com.faqs.eneity.Faqs;

public interface FaqsService {
	//���������ѯ
	public List<Faqs> selectFaqs(@Param("title")String title,@Param("classid")Integer classid);
	
	public List<Classes> showCId(@Param("Cid")Integer Cid);

}
