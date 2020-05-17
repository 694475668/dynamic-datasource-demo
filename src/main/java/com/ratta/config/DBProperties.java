package com.ratta.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 实际数据源配置
 * @author 刘明
 */
@Component
@Data
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {
	private HikariDataSource master;
	private HikariDataSource slave;
}
