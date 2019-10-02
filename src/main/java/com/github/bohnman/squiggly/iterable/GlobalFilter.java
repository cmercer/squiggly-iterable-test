package com.github.bohnman.squiggly.iterable;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class GlobalFilter extends SimpleBeanPropertyFilter {

  public static final String GLOBAL_FILTER_NAME="GLOBAL_FILTER";

  public GlobalFilter() {
    super();
  }
}
