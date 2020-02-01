package com.theresourceroom.api;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.logging.DefaultLoggingFactory;
import io.dropwizard.logging.LoggingFactory;
import io.dropwizard.metrics.MetricsFactory;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.server.ServerFactory;

public class Configuration extends io.dropwizard.Configuration {

    @Valid
    @NotNull
    private ServerFactory server = new DefaultServerFactory();

    @Valid
    @Nullable
    private LoggingFactory logging;

    @Valid
    @NotNull
    private MetricsFactory metrics = new MetricsFactory();

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("logging")
    public synchronized void setLoggingFactory(LoggingFactory factory) {
        this.logging = factory;
    }

    @JsonProperty("server")
    public void setServerFactory(ServerFactory factory) {
        this.server = factory;
    }

    @JsonProperty("metrics")
    public void setMetricsFactory(MetricsFactory metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("metrics")
    public MetricsFactory getMetricsFactory() {
        return metrics;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("server")
    public ServerFactory getServerFactory() {
        return server;
    }

    @JsonProperty("logging")
    public synchronized LoggingFactory getLoggingFactory() {
        if (logging == null) {
            // Lazy init to avoid a hard dependency to logback
            logging = new DefaultLoggingFactory();
        }
        return logging;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "server=" + server +
                ", logging=" + logging +
                ", metrics=" + metrics +
                ", database=" + database +
                '}';
    }
}