package com.faqs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.faqs.eneity.Classes;
import com.faqs.eneity.Faqs;

public interface FaqsMapper {
	
	
	public int count();
	
	//常见问题查询
		public List<Faqs> selectFaqs(@Param("title")String title,@Param("classid")Integer classid);
		//查看问题内容
		public Faqs selectFaqsKey(Integer id);
		//查询分类
		public List<Classes> selectClasses();
		//添加问题
		public int insertFaqs(Faqs faqs);
		
		public List<Classes> showCId(@Param("Cid")Integer Cid);
		
		public int UpdateFaqs(Faqs faqs);
		
		public List<Faqs> showFaqsIn(Integer[] Fid);
		
		public List<Faqs> showFaqsList(List<Integer> Fid);
		
		public List<Faqs> showFaqsMap(Map<String,Object> Fid);
		
}
