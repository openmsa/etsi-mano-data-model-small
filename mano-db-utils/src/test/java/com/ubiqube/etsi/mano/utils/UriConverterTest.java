package com.ubiqube.etsi.mano.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UriConverterTest {

	private UriConverter conv;

	@BeforeEach
	void setUp() {
		conv = new UriConverter();
	}

	@Test
	void test() {
		String res = conv.convertToDatabaseColumn(URI.create("http://www.google.com"));
		assertNotNull(res);
		assertEquals("http://www.google.com", res);
		assertNull(conv.convertToDatabaseColumn(null));
	}

	@Test
	void test2() {
		URI res = conv.convertToEntityAttribute("http://www.google.com");
		assertNotNull(res);
		assertEquals("http://www.google.com", res.toString());
		assertNull(conv.convertToEntityAttribute(null));
	}

	@Test
	void test3() {
		URI res = conv.convertToEntityAttribute("bad uri !!!");
		assertNull(res);
	}
}
