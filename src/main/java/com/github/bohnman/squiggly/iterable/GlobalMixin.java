package com.github.bohnman.squiggly.iterable;

import com.fasterxml.jackson.annotation.JsonFilter;

import net.jcip.annotations.ThreadSafe;

/**
 *
 */
@ThreadSafe
@JsonFilter(GlobalFilter.GLOBAL_FILTER_NAME)
public class GlobalMixin {

}
