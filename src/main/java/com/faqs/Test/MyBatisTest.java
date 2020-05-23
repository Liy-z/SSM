package com.faqs.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.faqs.eneity.Classes;
import com.faqs.eneity.Faqs;
import com.faqs.mapper.FaqsMapper;



public class MyBatisTest {
	@Test
	public void MyBatis() {
		SqlSession sqlSession= null;
		int count=0;
		String resource = "mybatis-config.xml";
	
			//sqlSession = MyBatisUtil.getSession();
		
			try {
				//1获取mybatis-config.xml的输入流
				InputStream is = Resources.getResourceAsStream(resource);
				//2创建SqlSessionFactory对象,完成对配置文件的读取
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
				//3创建sqlSession
				sqlSession = factory.openSession();
				//4调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
				count = sqlSession.selectOne("com.faqs.mapper.FaqsMapper.count");
				
				//count = sqlSession.getMapper(FaqsMapper.class).count();
				System.out.println("=============="+count);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				// TODO: handle finally clause
				sqlSession.close();
			}
	}
	
	@Test
	public void MyBatisUtilTest() {
		SqlSession sqlSession= null;
		int count=0;
	
		sqlSession = MyBatisUtil.getSession();
			
		count = sqlSession.getMapper(FaqsMapper.class).count();
		System.out.println("=============="+count);
			
		MyBatisUtil.closeSession();
		
		
	}
	@Test
	public void showClass() {
		SqlSession sqlSession = null;
		List<Classes> classesList = new ArrayList<Classes>();
		//Classes classes = new Classes();
		sqlSession = MyBatisUtil.getSession();
		
		//String Fname = "j";
		Integer id = 2;
		classesList = sqlSession.getMapper(FaqsMapper.class).showCId(id);
		
		MyBatisUtil.closeSession();
		System.out.println("=================List:"+classesList.size());
		for(Classes classes : classesList) {
			
			for(Faqs faqs: classes.getFaqsList() ) {
				System.out.println("id:"+faqs.getId() +
					"===========>标题:"+faqs.getTitle() + 
					"===========>内容:"+faqs.getContent());
			}
		}
	}
	
	@Test
	public void selectTest() {
		SqlSession sqlSession = null;
		List<Faqs> faqsList = new ArrayList<Faqs>();
		
		sqlSession = MyBatisUtil.getSession();
		
		//String Fname = "j";
		Integer Cid = 2;
		faqsList = sqlSession.getMapper(FaqsMapper.class).selectFaqs(null, Cid);
		
		MyBatisUtil.closeSession();
		System.out.println("===================List:"+faqsList.size());
		for(Faqs faqs: faqsList ) {
			System.out.println("Id:"+faqs.getId() +
				"===========>name:"+faqs.getTitle() + 
				"===========>类别:"+faqs.getClasses().getCname());
		}
		
	}
	/**
	 * 数组类型foreach查询sql
	 */
	@Test
	public void showListIn() {
		SqlSession sqlSession = null;
		List<Faqs> faqsList = new ArrayList<Faqs>();
		
		sqlSession = MyBatisUtil.getSession();
		
		Integer[] id = {2,4};
		faqsList = sqlSession.getMapper(FaqsMapper.class).showFaqsIn(id);
		
		MyBatisUtil.closeSession();
		System.out.println("======================List:"+faqsList.size());
		for(Faqs faqs: faqsList ) {
			System.out.println("===========>Id:"+faqs.getId() +
				"=============>name:"+faqs.getTitle());
		}
		
	}
	/**
	 * List类型foreach查询sql
	 */
	@Test
	public void showList() {
		SqlSession sqlSession = null;
		List<Faqs> faqsList = new ArrayList<Faqs>();
		
		sqlSession = MyBatisUtil.getSession();
		
		List<Integer> ids =  new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		
		faqsList = sqlSession.getMapper(FaqsMapper.class).showFaqsList(ids);
		
		MyBatisUtil.closeSession();
		System.out.println("======================List:"+faqsList.size());
		for(Faqs faqs: faqsList ) {
			System.out.println("===========>Id:"+faqs.getId() +
				"=============>name:"+faqs.getTitle());
		}
		
	}
	
	/**
	 * List类型foreach查询sql
	 */
	@Test
	public void showMap() {
		SqlSession sqlSession = null;
		List<Faqs> faqsList = new ArrayList<Faqs>();
		
		sqlSession = MyBatisUtil.getSession();
		
		List<Integer> ids =  new ArrayList<Integer>();
		ids.add(3);
		ids.add(2);
		
		Map<String,Object> idMap = new HashMap<String,Object>();
		idMap.put("aaa", 2);
		idMap.put("Ikey", ids);
		
		faqsList = sqlSession.getMapper(FaqsMapper.class).showFaqsMap(idMap);
		
		MyBatisUtil.closeSession();
		System.out.println("======================List:"+faqsList.size());
		for(Faqs faqs: faqsList ) {
			System.out.println("===========>Id:"+faqs.getId() +
				"=============>name:"+faqs.getTitle() + 
				"=============>ClassId:"+faqs.getClassid());
		}
		
	}
	
	@Test
	public void updateTest() {
		SqlSession sqlSession= null;
		int count=0;
		Faqs faqs = new Faqs();
		faqs.setId(2);
		faqs.setTitle("Java基础");
		faqs.setClassid(2);
		sqlSession = MyBatisUtil.getSession();
		count = sqlSession.getMapper(FaqsMapper.class).UpdateFaqs(faqs);
		sqlSession.commit();
		
		System.out.println("修改行数："+count);
		MyBatisUtil.closeSession();
	}
	
	
	
}
