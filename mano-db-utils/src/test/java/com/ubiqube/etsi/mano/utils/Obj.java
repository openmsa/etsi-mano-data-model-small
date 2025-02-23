package com.ubiqube.etsi.mano.utils;

import java.util.List;
import java.util.Map;

public class Obj {

	private List<String> list;

	private String str;

	private Map<String, String> map;

	private int i;

	private boolean b;

	private double d;

	private float f;

	private long l;

	private short s;

	private byte by;

	private char c;

	private Object o;

	private Object ignore;

	@ToStringIgnore
	private Object ignore2;

	public List<String> getList() {
		return list;
	}

	public void setList(final List<String> list) {
		this.list = list;
	}

	public String getStr() {
		return str;
	}

	public void setStr(final String str) {
		this.str = str;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(final Map<String, String> map) {
		this.map = map;
	}

	public int getI() {
		return i;
	}

	public void setI(final int i) {
		this.i = i;
	}

	public boolean isB() {
		return b;
	}

	public void setB(final boolean b) {
		this.b = b;
	}

	public double getD() {
		return d;
	}

	public void setD(final double d) {
		this.d = d;
	}

	public float getF() {
		return f;
	}

	public void setF(final float f) {
		this.f = f;
	}

	public long getL() {
		return l;
	}

	public void setL(final long l) {
		this.l = l;
	}

	public short getS() {
		return s;
	}

	public void setS(final short s) {
		this.s = s;
	}

	public byte getBy() {
		return by;
	}

	public void setBy(final byte by) {
		this.by = by;
	}

	public char getC() {
		return c;
	}

	public void setC(final char c) {
		this.c = c;
	}

	public Object getO() {
		return o;
	}

	public void setO(final Object o) {
		this.o = o;
	}

	@ToStringIgnore
	public Object getIgnore() {
		return ignore;
	}

	public void setIgnore(final Object ignore) {
		this.ignore = ignore;
	}

	public Object getIgnore2() {
		return ignore2;
	}

	public void setIgnore2(final Object ignore2) {
		this.ignore2 = ignore2;
	}

}
