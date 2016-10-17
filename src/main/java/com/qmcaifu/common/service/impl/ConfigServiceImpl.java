package com.qmcaifu.common.service.impl;

import com.qmcaifu.common.service.ConfigService;
import com.qmcaifu.configcenter.facade.ConfigFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nihao on 2016/10/17.
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Autowired
    private ConfigFacade configFacade;

    @Override
    public String getConfigValue(String key) {
        String value = null;
        try {
            value = configFacade.getConfigValue(key);
        } catch (Exception e) {
            LOGGER.error("配置获取异常  msg= {}", e);
        }
        return value;
    }
}
