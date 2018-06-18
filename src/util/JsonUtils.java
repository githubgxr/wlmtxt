package util;

import com.google.gson.Gson;

public class JsonUtils {
	private static Gson gson;	
	static{
		gson=new Gson();
	}
	public static Object toObject(String json,Class clazz) {
		return gson.fromJson(json, clazz);
	}
	public static String toJson(Object o) {
		return gson.toJson(o);
	}
}
