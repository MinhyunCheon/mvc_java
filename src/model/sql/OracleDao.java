package model.sql;

import java.util.List;

public interface OracleDao {
	// DML
	public int insertRow(Object obj);
	public int updateRow(Object obj);
	public int deleteRow(Object obj);
	
	// select
	public List<Object> selectRow();
	public Object selectRow(Object obj);
	public List<Object> selectCustom(Object obj);
}
