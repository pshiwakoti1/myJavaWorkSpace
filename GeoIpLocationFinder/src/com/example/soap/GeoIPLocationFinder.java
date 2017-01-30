package com.example.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class GeoIPLocationFinder {

	public static void main(String[] args) {
		
		String ip = args[0];
        GeoIPService service = new GeoIPService();
        GeoIPServiceSoap geoIpServiceSoap = service.getGeoIPServiceSoap();
        GeoIP geoIP = geoIpServiceSoap.getGeoIP(ip);
        System.out.println("Country: " + geoIP.getCountryName() + "Country Code: " + geoIP.getCountryCode());
	}

}
