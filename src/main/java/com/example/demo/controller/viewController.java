package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankia.NA.dao.SaldosMapper;
import com.bankia.NA.modelo.Saldos;
import com.bankia.NA.modelo.SaldosKey;

@Controller
@RequestMapping("/say")
public class viewController {

	private SaldosMapper mapSaldos;
	private static Log LOG =LogFactory.getLog(viewController.class); 

	@GetMapping("/hello")
	public ModelAndView sayHello() {

		ModelAndView mav = new ModelAndView("hello");
			
		SqlSession session = getSqlSessionFacto().openSession();
		try {
			mapSaldos = session.getMapper(SaldosMapper.class);
			SaldosKey sk = new SaldosKey();
			sk.setId(1);
			Saldos s = mapSaldos.selectByPrimaryKey(sk);
			LOG.info("El curso recuperado: " + s.toString());
			mav.addObject("descripcion", s.getDescription());
			
			
			
			
			
			
			
			s=new Saldos();
			s.setDescription("MyBatis en dos jornadas");
			s.setHours(3);
			s.setName("MyBatis");
			s.setPrize(34);
			
			mapSaldos.insertSelective(s);
			
			
			
			
			
		}
		finally {
		  session.close();
		}
		
		/*session = getSqlSessionFacto().openSession();
		try {
			mapSaldos = session.getMapper(SaldosMapper.class);
			SaldosKey sk = new SaldosKey();
			sk.setId(1);
			
			mapSaldos.deleteByPrimaryKey(sk);
			
			
			
		}
		finally {
		  session.close();
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return mav;
	}

	/* metodo que nos obtiene la sqlsesionfactory */
	private static SqlSessionFactory getSqlSessionFacto() {
		try {
			String resource = "com/example/demo/config.xml";
			org.apache.ibatis.logging.LogFactory.useCommonsLogging();
			Reader	inputStream = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
