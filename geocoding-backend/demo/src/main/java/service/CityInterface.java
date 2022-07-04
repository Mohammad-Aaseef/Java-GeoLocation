package service;



import mapper.GoogleGeoCode;

@FunctionalInterface
public interface CityInterface {

	public abstract String  getGeoCode(String address, boolean ssl);
}
