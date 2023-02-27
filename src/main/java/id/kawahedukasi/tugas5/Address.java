package id.kawahedukasi.tugas5;

/*
 7. Buatlah class Address yang memiliki attribute :
- street
- district
- city
- province
*/
public class Address {
    private String street;
    private String district;
    private String city;
    private String province;

    public Address(String street, String district, String city, String province) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
