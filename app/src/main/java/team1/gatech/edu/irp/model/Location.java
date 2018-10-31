package team1.gatech.edu.irp.model;


import android.support.annotation.NonNull;

import java.io.Serializable;


/****************************************************************************************
 *    LOCATION
 *    Notes: Represents a single Location which may have much information assigned
 *    information holder
 ****************************************************************************************
 */
public class Location implements Serializable {


//    /*********************************************************************************************
//     *    ATTRIBUTES
//     *****************************************************************************************
//     */

    /** unique id number */
    private int _id;

    /** the location name */
    private String _name;

    /** the location latitude */
    private Double _latitude;

    /** the location longitude */
    private Double _longitude;

    /** the street address for the location */
    private String _streetAddress;

    /** the city for the location */
    private String _city;

    /** the state for the location */
    private String _state;

    /** the zip code for the location */
    private int _zipCode;

    /** the list of all registered students for this course */
    private LocationTypeEnum _locationType;

    /** the phone number */
    private String _phoneNumber;

    /** the website link */
    private String _websiteLink;


//    /*********************************************************************************************
//     *    CONSTRUCTORS
//     *****************************************************************************************
//     */

    /**
     * Makes a new Location
     * @param id  the id of the location as an integer
     * @param name  the name of the location like "GOODWILL"
     * @param latitude the latitude of the location like "33.75416"
     * @param longitude the longitude of the location like "-84.37742"
     * @param streetAddress the street address for the location like "123 MAIN AVE SE"
     * @param city the city of the location like "Atlanta"
     * @param state the state of the location like "GA"
     * @param zipCode the latitude of the zipCode like "30332"
     * @param locationType the locationType of the location like "Drop off"
     * @param phoneNumber the phoneNumber of the location like "(770) 634 - 5309"
     * @param websiteLink the website link of the location like "www.goodDonation.com"
     *
     */
    public Location(int id, String name, Double latitude, Double longitude, String streetAddress,
                    String city, String state, int zipCode, LocationTypeEnum locationType,
                    String phoneNumber, String websiteLink) {
        _id = id;
        _name = name;
        _latitude = latitude;
        _longitude = longitude;
        _streetAddress = streetAddress;
        _city = city;
        _state = state;
        _zipCode = zipCode;
        _locationType = locationType;
        _phoneNumber = phoneNumber;
        _websiteLink = websiteLink;


    }


//    /*********************************************************************************************
//     *    GETTERS AND SETTERS
//     *****************************************************************************************
//     */

    /**
     * getter for the location name
     *
     * @return the location name
     */
    public String getName() { return _name; }

//    /**
//     * sets the location name
//     *
//     * @param name the location name
//     */
//    public void setName(String name) { _name = name; }

//    /**
//     * getter for the id
//     *
//     * @return the id
//     */
//    public int getId() { return _id; }

    /**
     * getter for the latitude
     *
     * @return the latitude
     */
    public Double getLatitude() { return _latitude; }

//    /**
//     * sets the latitude
//     *
//     * @param latitude the latitude
//     */
//    public void setLatitude(Double latitude) { _latitude = latitude; }

    /**
     * getter for the longitude
     *
     * @return the longitude
     */
    public Double getLongitude() { return _longitude; }

//    /**
//     * sets the longitude
//     *
//     * @param longitude the longitude
//     */
//    public void setLongitude(Double longitude) { _longitude = longitude; }

    /**
     * getter for the street address
     *
     * @return the street address
     */
    public String getStreetAddress() { return _streetAddress; }

//    /**
//     * sets the street address
//     *
//     * @param streetAddress the street address
//     */
//    public void setStreetAddress(String streetAddress) { _streetAddress = streetAddress; }

    /**
     * getter for the city
     *
     * @return the city
     */
    public String getCity() { return _city; }

//    /**
//     * sets the city
//     *
//     * @param city the city
//     */
//    public void setCity(String city) { _city = city; }

    /**
     * getter for the state
     *
     * @return the state
     */
    public String getState() { return _state; }

//    /**
//     * sets the state
//     *
//     * @param state the state
//     */
//    public void setState(String state) { _state = state; }

    /**
     * getter for the zipCode
     *
     * @return the zipCode
     */
    public int getZipCode() { return _zipCode; }

//    /**
//     * sets the zipCode
//     *
//     * @param zipCode the zipCode
//     */
//    public void setZipCode(int zipCode) { _zipCode = zipCode; }

    /**
     * getter for the locationType
     *
     * @return the locationType
     */
    public LocationTypeEnum getLocationType() { return _locationType; }

//    /**
//     * sets the locationType
//     *
//     * @param locationType the locationType
//     */
//    public void setLocationType(LocationTypeEnum locationType) { _locationType = locationType; }

    /**
     * getter for the phoneNumber
     *
     * @return the phoneNumber
     */
    public String getPhoneNumber() { return _phoneNumber; }

//    /**
//     * sets the phoneNumber
//     *
//     * @param phoneNumber the phoneNumber
//     */
//    public void setPhoneNumber(String phoneNumber) { _phoneNumber = phoneNumber; }

    /**
     * getter for the websiteLink
     *
     * @return the websiteLink
     */
    public String getWebsiteLink() { return _websiteLink; }

//    /**
//     * sets the websiteLink
//     *
//     * @param websiteLink the websiteLink
//     */
//    public void setWebsiteLink(String websiteLink) { _websiteLink = websiteLink; }

//         METHODS


    /**
     * Override the toString to just return the "location name" and "street address"
     *
     * @return the display string representation
     */
    @NonNull
    @Override
    public String toString() {
        return _name + " " + _streetAddress;
    }

    /**
     * Override the equals to just check the "name"
     *
     * @return the success of the equals test
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location)) {
            return false;
        }
        Location l = (Location) o;
        return (l.getName().equals(_name));
    }

}

