package com.faqs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.faqs.eneity.Classes;
import com.faqs.eneity.Faqs;

public interface FaqsMapper {
	
	
	public int count();
	
	//���������ѯ
		public List<Faqs> selectFaqs(@Param("title")String title,@Param("classid")Integer classid);
		//�鿴��������
		public Faqs selectFaqsKey(Integer id);
		//��ѯ����
		public List<Classes> selectClasses();
		//�������
		public int insertFaqs(Faqs faqs);
		
		public List<Classes> showCId(@Param("Cid")Integer Cid);
		
		public int UpdateFaqs(Faqs faqs);
		
		public List<Faqs> showFaqsIn(Integer[] Fid);
		
		public List<Faqs> showFaqsList(List<Integer> Fid);
		
		public List<Faqs> showFaqsMap(Map<String,Object> Fid);
		
}
