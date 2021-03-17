package com.yp.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author yipeng
 * @Date 2021/3/17 11:41
 * @Version 1.0
 * @Desc
 */
@ConfigurationProperties(prefix = "yp.redission")
public class RedissonProperties {

    private String host = "localhost";

    private int port = 6379;

    private int timeout;

    private String password;

    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
