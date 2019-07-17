package com.github.bohnman.squiggly.iterable;

public class Person {
  private String name;
  private IterableWrapper<String> pets;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Iterable getPets() {
    return pets;
  }

  public void setPets(Iterable<String> pets) {
    this.pets = new IterableWrapper<>(pets);
  }
}
