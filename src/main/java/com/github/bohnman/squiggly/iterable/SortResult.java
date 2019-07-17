package com.github.bohnman.squiggly.iterable;

import org.springframework.data.domain.Sort;

public class SortResult {

  private String name;

  private Sort sort;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }
}
