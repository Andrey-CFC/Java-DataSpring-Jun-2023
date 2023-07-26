package bg.softuni.ModelMapper.entities.dtos;

public class AddressDTO {
    private String country;
    private String addressCity;

    public AddressDTO(String country, String addressCity) {
        this.country = country;
        this.addressCity = addressCity;
    }

    public String getCountry() {
        return country;
    }

    public String getAddressCity() {
        return addressCity;
    }

}
