package com.qmcaifu.common.service;

/**
 * Created by nihao on 2016/9/19.
 * 封装redis常用操作
 */
public interface RedisService {
    /**
     * redis set 操作
     * key 形式 user:userid:name 冒号分割
     * @param key
     * @param value
     */
    public void set(String key, Object value);

    /**
     * set操作
     * 注意：key被重新设置后过期时间会被清除，需要再次设置过期时间
     * @param key
     * @param value
     * @param expireSecs key生存时间
     */
    public void set(String key, Object value, int expireSecs);

    /**
     * redis 根据key获取值操作
     * @param key
     * @param clazz dto必须存在没有参数的构造方法
     * @param <T> 类型
     * @return
     */
    public <T> T get(String key, Class<T> clazz);

    /**
     * 返回string值
     * @param key
     * @return
     */
    public String get(String key);

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean exists(String key);

    /**
     * 删除key
     * @param key
     * @return
     */
    public String del(String key);

}
