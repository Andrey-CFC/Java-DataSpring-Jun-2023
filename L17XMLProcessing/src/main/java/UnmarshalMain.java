import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.InputStream;

public class UnmarshalMain {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(AddressesDTO.class);

        Unmarshaller listUnmarshaller = context.createUnmarshaller();

//        AddressesDTO addressesDTO = (AddressesDTO) listUnmarshaller.unmarshal(System.in);
//        System.out.println(addressesDTO);

        InputStream resourceAsStream = UnmarshalMain.class.getResourceAsStream("simple.xml");

        AddressesDTO fromFile = (AddressesDTO) listUnmarshaller.unmarshal(resourceAsStream);
        System.out.println(fromFile);
    }
}
