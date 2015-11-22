package seers.irda.dao.utils;

import java.util.HashMap;
import java.util.Map;

public class DaoUtils {

	public static Map<String, Object> createParameters(String[] paramNames, Object[] params) {
		Map<String, Object> paramsMap = new HashMap<>();
		for (int i = 0; i < params.length; i++) {
			Object param = params[i];
			paramsMap.put(paramNames[i], param);

		}
		return paramsMap;
	}

}
