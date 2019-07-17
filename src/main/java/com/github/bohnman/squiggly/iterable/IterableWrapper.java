package com.github.bohnman.squiggly.iterable;

import java.util.Iterator;

public class IterableWrapper<T> implements Iterable<T>{

  private final Iterable<T> iterable;

  public IterableWrapper(Iterable<T> iterable) {
    this.iterable = iterable;
  }


  @Override
  public Iterator<T> iterator() {
    return iterable.iterator();
  }
}
