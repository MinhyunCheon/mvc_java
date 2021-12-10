package service;

import java.util.List;

public interface BbsService {
	public int insertSv(Object obj);
	public int updateSv(Object obj);
	public int deleteSv(Object obj);
	
	public List<Object> selectSv();
	public Object selectSv(Object obj);
}
