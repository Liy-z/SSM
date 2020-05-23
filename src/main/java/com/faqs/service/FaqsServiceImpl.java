package com.faqs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faqs.eneity.Classes;
import com.faqs.eneity.Faqs;
import com.faqs.mapper.FaqsMapper;
@Service
public class FaqsServiceImpl implements FaqsService{
	@Autowired
	private FaqsMapper fm;

	@Override
	public List<Faqs> selectFaqs(String title, Integer classid) {
		// TODO Auto-generated method stub
		List<Faqs> list = fm.selectFaqs(title, classid);
		return list;
	}

	@Override
	public List<Classes> showCId(Integer Cid) {
		// TODO Auto-generated method stub
		List<Classes> list = fm.showCId(Cid);
		return list;
	}

}
