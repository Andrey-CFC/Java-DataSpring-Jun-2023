package bg.softuni.ModelMapper.services;

import bg.softuni.ModelMapper.entities.Address;
import bg.softuni.ModelMapper.entities.dtos.AddressDTO;
import bg.softuni.ModelMapper.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    public Address create(AddressDTO data) {
        Address address = mapper.map(data,Address.class);

        return this.addressRepository.save(address);
    }
}
