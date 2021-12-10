package service;

import java.util.List;

import model.sql.OracleDao;
import model.sql.OracleDaoImpl;

public class BbsServiceImpl implements BbsService {
	// DI
	private OracleDao dao;
	
	public BbsServiceImpl() {
		dao = new OracleDaoImpl();
	}

	@Override
	public int insertSv(Object obj) {
		System.out.println("Service insertSv");
		return dao.insertRow(obj);
	}

	@Override
	public int updateSv(Object obj) {
		System.out.println("Service updateSv");
		return dao.updateRow(obj);
	}

	@Override
	public int deleteSv(Object obj) {
		System.out.println("Service deleteSv");
		return dao.deleteRow(obj);
	}

	@Override
	public List<Object> selectSv() {
		System.out.println("Service selectSv1");
		return dao.selectRow();
	}

	@Override
	public Object selectSv(Object obj) {
		System.out.println("Service selectSv2");
		return dao.selectRow(obj);
	}

}
