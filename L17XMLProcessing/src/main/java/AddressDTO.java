import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.io.Serializable;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDTO implements Serializable {

    @XmlElement(name = "country")
    private String country;

    @XmlElement(name = "city")
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public AddressDTO() {
    }
}
