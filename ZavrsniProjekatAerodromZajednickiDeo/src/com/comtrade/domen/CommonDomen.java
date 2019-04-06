package com.comtrade.domen;

import java.sql.ResultSet;
import java.util.List;

public interface CommonDomen {
	
	public String returnNameForTable();
	public String returnNameForInsert();
	public String returnNameForUpdate(CommonDomen cd);
	public String returnNameForSelect();
	public List<CommonDomen>manageSelect(ResultSet rs);
	public String returnNameForColumn();
}
