package com.ahau.configs;


import com.ahau.BambootattanServerApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class ElasticSearchConfig {
    private static final Logger LOGGER = LogManager.getLogger(ElasticSearchConfig.class);

    @Bean
    public TransportClient client() {
        LOGGER.info("初始化开始中...");
        TransportClient client = null;
        try {
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName("47.104.26.79"),
                    9300);
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", "elasticsearch")
                    .build();
            // 配置信息Settings自定义
            client = new PreBuiltTransportClient(esSetting);
            client.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            LOGGER.error("elasticsearch TransportClient create error!!!", e);
        }
        return client;
    }
}
