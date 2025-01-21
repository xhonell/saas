package com.xhonell.commons;

import java.util.Map;

/**
 * program: saas
 * ClassName AdminThreadLocal
 * description:
 * author: xhonell
 * create: 2025年01月21日20时41分
 * Version 1.0
 **/
public class AdminThreadLocal {
    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    /**
     * 绑定当前县城
     * @param map 要绑定的数据
     */
    public static void set(Map<String,Object> map){
        threadLocal.set(map);
    }

    /**
     * 去除线程的数据
     * @return 数据
     */
    public static Map<String,Object> get(){
        return threadLocal.get();
    }

    /**
     * 移除线程的数据
     */
    public static void remove(){
        threadLocal.remove();
    }
}
