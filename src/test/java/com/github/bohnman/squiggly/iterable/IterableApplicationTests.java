package com.github.bohnman.squiggly.iterable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IterableApplicationTests {

	private ObjectMapper jacksonMapper;
	private ObjectMapper squigglyMapper;
	private Person person;
	private SortResult sortResult;
	private Page<String> page;

	@Before
	public void before() {
		jacksonMapper = new ObjectMapper();
		squigglyMapper = Squiggly.init(new ObjectMapper(), "**");

		person = new Person();
		person.setName("Jim Henson");
		List<String> pets = new ArrayList<>();
		pets.add("Kermit the Frog");
		pets.add("Miss Piggy");
		pets.add("Sam the Eagle");
		person.setPets(pets);

		sortResult = new SortResult();
		sortResult.setName("SortResult");
		Sort s = new Sort(
				new Sort.Order("id"),
				new Sort.Order("name")
		);
		sortResult.setSort(s);

		Pageable pageable = new PageRequest(0, 10, s);
		page = new PageImpl<>(pets, pageable, 3);
	}

	@After
	public void after() {
    jacksonMapper = null;
    squigglyMapper = null;
	}

	@Test
  public void personTest() throws JsonProcessingException {
		String jacksonResult = jacksonMapper.writeValueAsString(person);
		String squigglyResult = squigglyMapper.writeValueAsString(person);
		Assert.assertEquals(jacksonResult, squigglyResult);
  }

  @Test
	public void sortResultTest() throws JsonProcessingException {
		String jacksonResult = jacksonMapper.writeValueAsString(sortResult);
		String squigglyResult = squigglyMapper.writeValueAsString(sortResult);
		assertThat(jacksonResult).isEqualTo(squigglyResult);
	}

	@Test
	public void pageTest() throws JsonProcessingException {
		String jacksonResult = jacksonMapper.writeValueAsString(page);
		String squigglyResult = squigglyMapper.writeValueAsString(page);
		assertThat(jacksonResult).isEqualTo(squigglyResult);
	}

}
