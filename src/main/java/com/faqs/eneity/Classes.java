package com.faqs.eneity;

import java.util.List;

public class Classes {

	private int id;//�����
	private String cname;//�������
	
	private List<Faqs> faqsList;//�����б�
	
	public List<Faqs> getFaqsList() {
		return faqsList;
	}
	public void setFaqsList(List<Faqs> faqsList) {
		this.faqsList = faqsList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
