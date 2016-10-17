package com.qmcaifu.common.service;

/**
 * Created by nihao on 2016/10/17.
 */
public interface ConfigService {

    /**
     * 根据key 去配置中心取配置
     * @param key
     * @return
     */
    public String getConfigValue(String key);
}
