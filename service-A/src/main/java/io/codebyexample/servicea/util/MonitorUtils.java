package io.codebyexample.servicea.util;

/** @author sateam */
public final class MonitorUtils {

  public static final String TABLE_TAG = "table";
  private static final String METRIC_PREFIX = "bank_binding_";
  public static final String GRPC_METRIC = METRIC_PREFIX + "grpc";
  public static final String CACHE_METRIC = METRIC_PREFIX + "cache";
  public static final String REPO_METRIC = METRIC_PREFIX + "repo";
  public static final String OBS_METRIC = METRIC_PREFIX + "obs";
  public static final String BANK_CONFIG_METRIC = METRIC_PREFIX + "bank_config";

  private MonitorUtils() {}
}
