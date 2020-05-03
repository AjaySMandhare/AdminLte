package com.javabykiran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.dao.OperatorDao;
import com.javabykiran.model.Operatorlist;


@Service
public class OperatorService {
	
	@Autowired
	private OperatorDao operatorDao;
	
	public List<Operatorlist> OperatorList()
	{
		List<Operatorlist>list=operatorDao.OperatorsList();
		return list;
	}

}
