package team1.gatech.edu.irp.model;



/**
 * Created by mitchellalvarado on 10/5/16.
 *
 * Represents a single Location which may have much information assigned
 *
 * Information Holder
 */
public class Location {

    /** allow us to assign unique number to the location */
    private static int nextNo = 1;

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
    private LocationType _locationType;

    /** the phone number */
    private String _phoneNumber;

    /** the website link */
    private String _websiteLink;


    /**
     * Makes a new Location
     * @param name  the name of the location like "GOODWILL"
     * @param latitude the latitude of the location like "33.75416"
     * @param longitude the longitude of the location like "-84.37742"
     * @param streetAddress the street address for the location like "123 MAIN AVE SE"
     * @param city the city of the location like "Atlanta"
     * @param state the state of the location like "GA"
     * @param zipCode the latitude of the zipCode like "30332"
     * @param locationType the locationType of the location like "Drop off"
     * @param phoneNumber the phoneNumber of the location like "(770) 634 - 5309"
     * @param websiteLink the website link of the location like "www.gooddonation.com"
     *
     */
    public Location(String name, Double latitude, Double longitude, String streetAddress,
                    String city, String state, int zipCode, LocationType locationType,
                    String phoneNumber, String websiteLink) {
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
        _id = Location.nextNo++;

    }

    public Location() {
        _name = "Test Store";
        _latitude = 23.33223;
        _longitude = -23.85674;
        _streetAddress = "TEST STREET";
        _city = "TestCity";
        _state = "GA";
        _zipCode = 12345;
        _locationType = LocationType.DROPOFFONLY;
        _phoneNumber = "(770) 634 - 5309";
        _websiteLink = "www.testsite.com";
        _id = Location.nextNo++;

    }

    @Override
    public boolean equals(Object o) {
        Location l = (Location) o;
        return (l.getName().equals(_name) && l.getStreetAddress().equals(_streetAddress));
    }

    /* *****************************************
     * All the property setters and getters
     * */
    public String getName() { return _name; }
    public void setName(String name) { _name = name; }

    public int getId() { return _id; }

    public Double getLatitude() { return _latitude; }
    public void setLatitude(Double latitude) { _latitude = latitude; }

    public Double getLongitude() { return _longitude; }
    public void setLongitude(Double longitude) { _longitude = longitude; }

    public String getStreetAddress() { return _streetAddress; }
    public void setStreetAddress(String streetAddress) { _streetAddress = streetAddress; }

    public String getCity() { return _city; }
    public void setCity(String city) { _city = city; }

    public String getState() { return _state; }
    public void setState(String state) { _state = state; }

    public int getZipCode() { return _zipCode; }
    public void setZipCode(int zipCode) { _zipCode = zipCode; }

    public LocationType getLocationType() { return _locationType; }
    public void setLocationType(LocationType locationType) { _locationType = locationType; }

    public String getPhoneNumber() { return _phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { _phoneNumber = phoneNumber; }

    public String getWebsiteLink() { return _websiteLink; }
    public void setWebsiteLink(String websiteLink) { _websiteLink = websiteLink; }


    @Override
    public String toString() {
        return _name + " " + _streetAddress + " " + _locationType;
    }

}

