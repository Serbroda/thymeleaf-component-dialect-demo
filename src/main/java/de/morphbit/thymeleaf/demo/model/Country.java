package de.morphbit.thymeleaf.demo.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class Country {

	private String isoCode;

	@NotNull
	private String name;

	public Country() {
	}

	public Country(String isoCode, String name) {
		this.isoCode = isoCode;
		this.name = name;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Country other)) return false;
		return Objects.equals(isoCode, other.isoCode);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(isoCode);
	}

	@Override
	public String toString() {
		return "Country [isoCode=" + isoCode + ", name=" + name + "]";
	}
}
