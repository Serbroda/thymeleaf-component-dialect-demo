package de.morphbit.thymeleaf.demo.model;

public class Country {

	private String isoCode;
	private String name;

	public Country() {

	}

	public Country(String isoCode, String name) {
		super();
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
	    if (obj == null) {
	        return false;
	    }
	    if (!Country.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Country other = (Country) obj;
	    if ((this.isoCode == null) ? (other.isoCode != null) : !this.isoCode.equals(other.isoCode)) {
	        return false;
	    }
	    return true;
	}

	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.isoCode != null ? this.isoCode.hashCode() : 0);
	    return hash;
	}

	@Override
	public String toString() {
		return "Country [isoCode=" + isoCode + ", name=" + name + "]";
	}

}
