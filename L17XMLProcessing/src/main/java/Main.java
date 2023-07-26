import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {

        AddressDTO address1 = new AddressDTO("Bulgaria", "Varna");

        JAXBContext jaxbContext = JAXBContext.newInstance(AddressDTO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(address1, System.out);

        JAXBContext jaxbListContext = JAXBContext.newInstance(AddressesDTO.class);
        Marshaller listMarshaller = jaxbListContext.createMarshaller();
        listMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        AddressesDTO addressesDTO = new AddressesDTO(List.of(address1));
        listMarshaller.marshal(addressesDTO, System.out);
    }
}
