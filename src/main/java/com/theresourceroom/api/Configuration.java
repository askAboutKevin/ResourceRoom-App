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
//import io.dropwizard.setup.AdminFactory;


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

    //    @Valid
    //    @NotNull
    //    private AdminFactory admin = new AdminFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    @JsonProperty("server")
    public ServerFactory getServerFactory() {
        return server;
    }

    @JsonProperty("server")
    public void setServerFactory(ServerFactory factory) {
        this.server = factory;
    }

    @JsonProperty("logging")
    public synchronized LoggingFactory getLoggingFactory() {
        if (logging == null) {
            // Lazy init to avoid a hard dependency to logback
            logging = new DefaultLoggingFactory();
        }
        return logging;
    }

    @JsonProperty("logging")
    public synchronized void setLoggingFactory(LoggingFactory factory) {
        this.logging = factory;
    }

    @JsonProperty("metrics")
    public MetricsFactory getMetricsFactory() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetricsFactory(MetricsFactory metrics) {
        this.metrics = metrics;
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