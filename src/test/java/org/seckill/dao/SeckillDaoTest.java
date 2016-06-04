package org.seckill.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

import javax.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * @author Quan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	@Resource
	private SeckillDao seckillDao;
	
	
	/*@Test
	public void testQueryById() throws Exception{
		long id = 1001;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}*/
	
	
	@Test
	public void testReduceNumber() throws Exception{
		int updateCount = seckillDao.reduceNumber(1000, new Date());
		System.out.println("updateCount="+updateCount);
	}
	
	
	/*@Test
	public void testQueryAll() throws Exception{
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for ( Seckill seckill : seckills ) {
			System.out.println(seckill);
		}
	}*/
}
