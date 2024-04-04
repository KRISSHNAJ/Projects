package youtube.krishnaitprojects.utils;

import java.sql.Date;

public class Tools {
	
	public static Date getSqlCurrentDate() {
		Date currentDate = new Date(System.currentTimeMillis());
		return currentDate;
	}

}
