package com.wudi.school.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * Json与javaBean之间的转换工具类
 *
 * }
 */
public class JsonUtils {

    /**
     * 从一个JSON 对象字符格式中得到一个java对象
     *
     * @param jsonString
     * @param beanCalss
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
        return bean;

    }

    /**
     * 将java对象转换成json字符串
     *
     * @param bean
     * @return
     */
    public static String beanToJson(Object bean) {

        JSONObject json = JSONObject.fromObject(bean);

        return json.toString();

    }
    /**
     * 将java对象转换成json字符串
     *
     * @param bean
     * @return
     */
    public static JSONObject beanToJsonObject(Object bean, String[] _nory_changes, boolean nory) {
        JSONObject json = null;
        if(null==bean){
            json=new JSONObject();
            return json;
        }
        if(nory){//转换_nory_changes里的属性

            Field[] fields = bean.getClass().getDeclaredFields();
            String str = "";
            for(Field field : fields){
                str+=(":"+field.getName());
            }
            fields = bean.getClass().getSuperclass().getDeclaredFields();
            for(Field field : fields){
                str+=(":"+field.getName());
            }
            str+=":";
            for(String s : _nory_changes){
                str = str.replace(":"+s+":", ":");
            }
            json = JSONObject.fromObject(bean,configJson(str.split(":")));

        }else{//转换除了_nory_changes里的属性
            json = JSONObject.fromObject(bean,configJson(_nory_changes));
        }
        return json;
    }
    /**
     * 将java对象转换成json字符串
     *
     * @param bean
     * @return
     */
    public static String beanToJson(Object bean, String[] _nory_changes, boolean nory) {
       return beanToJsonObject(bean,_nory_changes,nory).toString();
    }
    private static JsonConfig configJson(String[] excludes) {

        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(false);

        return jsonConfig;

    }





    /**
     * 将java对象List集合转换成json字符串
     * @param beans
     * @return
     */
    public static String beanListToJson(List<?> beans) {

        StringBuffer rest = new StringBuffer();

        rest.append("[");

        int size = beans.size();

        for (int i = 0; i < size; i++) {

            rest.append(beanToJson(beans.get(i))+((i<size-1)?",":""));

        }

        rest.append("]");

        return rest.toString();

    }

    /**
     *将java对象List集合某些键值对转换成json字符串
     * @param beans
     * @param
     * @return
     */
    public static String beanListToJson(List<?> beans, String[] _nory_changes, boolean nory) {

        StringBuffer rest = new StringBuffer();

        rest.append("[");

        int size = beans.size();

        for (int i = 0; i < size; i++) {
            try{
                rest.append(beanToJson(beans.get(i),_nory_changes,nory));
                if(i<size-1){
                    rest.append(",");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        rest.append("]");

        return rest.toString();

    }

    /**
     * 从json HASH表达式中获取一个map，改map支持嵌套功能
     *
     * @param jsonString
     * @return
     */
    public static Map<Object, Object> jsonToMap(String jsonString) {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Iterator<?> keyIter = jsonObject.keys();
        String key;
        Object value;
        Map<Object, Object> valueMap = new HashMap<Object, Object>();

        while (keyIter.hasNext()) {

            key = (String) keyIter.next();
            value = jsonObject.get(key).toString();
            valueMap.put(key, value);

        }

        return valueMap;
    }
    
    /**
     * json转化为map，返回字符串参数的Map对象
     * @param jsonString
     * @return
     */
    public static Map<String, String> jsonToMapTwo(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Iterator<?> keyIter = jsonObject.keys();
        String key;
        String value;
        Map<String, String> valueMap = new HashMap<String, String>();
        while (keyIter.hasNext()) {
            key = (String) keyIter.next();
            value = jsonObject.get(key).toString();
            valueMap.put(key, value);
        }
        return valueMap;
    }

    /**
     * map集合转换成json格式数据
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, ?> map, String[] _nory_changes, boolean nory){

        String s_json = "{";

        Set<String> key = map.keySet();
        for (Iterator<?> it = key.iterator(); it.hasNext();) {
            String s = (String) it.next();
            if(map.get(s) == null){

            }else if(map.get(s) instanceof List<?>){
                s_json+=(s+":"+JsonUtils.beanListToJson((List<?>)map.get(s), _nory_changes, nory));

            }else{
                JSONObject json = JSONObject.fromObject(map);
                s_json += (s+":"+json.toString());;
            }

            if(it.hasNext()){
                s_json+=",";
            }
        }

        s_json+="}";
        return s_json;
    }

    /**
     * 从json数组中得到相应java数组
     *
     * @param jsonString
     * @return
     */
    public static Object[] jsonToObjectArray(String jsonString) {

        JSONArray jsonArray = JSONArray.fromObject(jsonString);

        return jsonArray.toArray();

    }

    public static String listToJson(List<?> list) {

        JSONArray jsonArray = JSONArray.fromObject(list);

        return jsonArray.toString();

    }

    /**
     * 从json对象集合表达式中得到一个java对象列表
     *
     * @param jsonString
     * @param beanClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> jsonToBeanList(String jsonString, Class<T> beanClass) {

        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        JSONObject jsonObject;
        T bean;
        int size = jsonArray.size();
        List<T> list = new ArrayList<T>(size);

        for (int i = 0; i < size; i++) {

            jsonObject = jsonArray.getJSONObject(i);
            bean = (T) JSONObject.toBean(jsonObject, beanClass);
            list.add(bean);

        }

        return list;

    }
    
    /**
     * 判断字符串是否可以转化为json对象
     * @param content
     * @return
     */
    public static boolean isJsonObject(String content) {
    	// 此处应该注意，不要使用StringUtils.isEmpty(),因为当content为"  "空格字符串时，JSONObject.fromObject可以解析成功，
    	// 实际上，这是没有什么意义的。所以content应该是非空白字符串且不为空，判断是否是JSON数组也是相同的情况。
    	if(StringUtils.isBlank(content))
    		return false;
    	try {
    		JSONObject jsonStr = JSONObject.fromObject(content);
            return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    /**
     * 判断字符串是否可以转化为JSON数组
     * @param content
     * @return
     */
    public static boolean isJsonArray(String content) {
    	
    	if(StringUtils.isBlank(content))
            return false;
        StringUtils.isEmpty(content);
        try { 
        	JSONArray jsonStr = JSONArray.fromObject(content); 
        	return true; 
        } catch (Exception e) { 
        	return false; 
        }
    }
}