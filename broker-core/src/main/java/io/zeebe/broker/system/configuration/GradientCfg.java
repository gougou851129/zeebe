/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.broker.system.configuration;

import io.zeebe.util.Environment;

public class GradientCfg {

  private int minLimit = 10;
  private int initialLimit = 20;
  private double rttTolerance = 2.0;

  public void init(final Environment environment) {
    environment
        .getInt(EnvironmentConstants.ENV_BROKER_BACKPRESSURE_GRADIENT_MINLIMIT)
        .ifPresent(this::setMinLimit);
    environment
        .get(EnvironmentConstants.ENV_BROKER_BACKPRESSURE_GRADIENT_RTTTOLERANCE)
        .map(Double::parseDouble)
        .ifPresent(this::setRttTolerance);
    environment
        .getInt(EnvironmentConstants.ENV_BROKER_BACKPRESSURE_GRADIENT_INITIALLIMIT)
        .ifPresent(this::setInitialLimit);
  }

  public int getMinLimit() {
    return this.minLimit;
  }

  public void setMinLimit(final int minLimit) {
    this.minLimit = minLimit;
  }

  public int getInitialLimit() {
    return this.initialLimit;
  }

  public void setInitialLimit(final int initialLimit) {
    this.initialLimit = initialLimit;
  }

  public double getRttTolerance() {
    return rttTolerance;
  }

  public void setRttTolerance(final double rttTolerance) {
    this.rttTolerance = rttTolerance;
  }
}
