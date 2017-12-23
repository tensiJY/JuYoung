package com.juyoung.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.juyoung.persistence.PointDAO;

@Service
public class PointServiceImpl implements PointService{

	@Inject
	private PointDAO pdao;
	
	@Override
	public void updatePoint(String mid, int point) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("MID", mid);
		map.put("POINT", point);
		pdao.updatePoint(map);
	}
	
}
