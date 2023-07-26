import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name="addresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressesDTO implements Serializable {

    @XmlElementWrapper(name = "wrap")
    @XmlElement
    private List<AddressDTO> addresses;

    public AddressesDTO() {
    }

    public AddressesDTO(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
