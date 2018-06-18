package util;

import java.lang.reflect.Field;

public class ReflectUtil {
	

	/**
	 * 获取对象所有属性
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void getAllField(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class obj_class = (Class)obj.getClass();
		 Field[] fs = obj_class.getDeclaredFields();//得到属性集合
	        for (Field f : fs) {//遍历属性
	            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
	            Object val = f.get(obj);// 得到此属性的值
	            if (val == null) {
					f.set(obj, "");
				}
	        }
	}
	
	
}
