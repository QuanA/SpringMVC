package org.seckill.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
					   "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	/*
	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
	}
	
	@Test
	public void testGetById() throws Exception {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}
	
	*/
	@Test
	public void testExportSeckillLogic() throws Exception {
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if (exposer.isExposer()) {
			logger.info("exposer={}", exposer);
			long phone = 12364456650L;
			String md5 = "9ab5994916a1535cfc5d9233ca68b6fe";
			try {
				SeckillExecution excution = seckillService.executeSeckill(id, phone, md5);
				logger.info("result={}", excution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		} else {
			// ÃëÉ±Î´¿ªÆô
			logger.warn("exposer={}", exposer);
		}
	}

}
