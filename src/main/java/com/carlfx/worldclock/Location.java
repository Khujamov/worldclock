package com.carlfx.worldclock;

import javafx.scene.image.Image;

public class Location {
    private String clockTime;
    private String timezone;
    private String city;
    private String country;
    private String countryCode;
    private double[] latLong = null;
    private Image weatherImage;
    private float temperature;
    private TEMP_STD tempType;
    /*

    Date localTime = new Date();

    // Standard DateTime format
    String standardDateFormat = "yyyy-MM-dd HH:mm:ss";

    // GMT formatter and parser
    SimpleDateFormat stdDateFormat = new SimpleDateFormat(standardDateFormat);
    stdDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

    // Convert local time to GMT time
    String localDateTime = "2020-12-06 15:49:00"; // 3:49:00 pm
    Date gmtDateTime = null;
    try {
        // local as gmt datetime
        gmtDateTime = stdDateFormat.parse(localDateTime);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    // Convert to another Timezone
    SimpleDateFormat otherTimezone = new SimpleDateFormat(standardDateFormat);
    otherTimezone.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));

    // Converting Celsius to Farenheit
    T(°F) = T(°C) × 1.8 + 32

    // Converting Farenheit to Celsius
    T(°C) = (T(°F) - 32) / 1.8

 */
    public enum TEMP_STD {
        CELSIUS,
        FAHRENHEIT
    }

    public Location(String timezone, String city, String countryCode) {
        this.timezone = timezone;
        this.city = city;
        this.countryCode = countryCode;
    }

    public Location(String timezone, String city, String countryCode, double [] latLong) {
        this(timezone, city, countryCode);
        this.latLong = latLong;
    }

    public Location(String timezone, String city, String countryCode, float temp, TEMP_STD tempType) {
        this(timezone, city, countryCode);
        this.temperature = temp;
        this.tempType = tempType;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return getFullLocationName().equals( ((Location) other).getFullLocationName());
    }

    public String getFullLocationName() {
        return getCity() + ", " + getCountryCode();
    }

    public String getClockTime() {
        return clockTime;
    }

    public void setClockTime(String clockTime) {
        this.clockTime = clockTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double[] getLatLong() {
        return latLong;
    }

    public void setLatLong(double[] latLong) {
        if (latLong == null || latLong.length != 2) {
            throw new IllegalArgumentException("Latitude and Longitude is a two element array of type double.");
        }
        this.latLong = latLong;
    }
    public void setLatLong(String lat, String lon) {
        double[] latLong = new double[2];
        latLong[0]= Double.parseDouble(lat);
        latLong[1]= Double.parseDouble(lon);
        this.latLong = latLong;
    }

    public double getLatitude() {
        return this.latLong[0];
    }
    public double getLongitude() {
        return this.latLong[1];
    }

    public Image getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(Image weatherImage) {
        this.weatherImage = weatherImage;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public TEMP_STD getTempType() {
        return tempType;
    }

    public void setTempType(TEMP_STD tempType) {
        this.tempType = tempType;
    }
}
