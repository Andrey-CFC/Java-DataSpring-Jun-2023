package bg.softuni.ModelMapper.services;

import bg.softuni.ModelMapper.entities.Address;
import bg.softuni.ModelMapper.entities.dtos.AddressDTO;

public interface AddressService {
    Address create(AddressDTO data);
}
