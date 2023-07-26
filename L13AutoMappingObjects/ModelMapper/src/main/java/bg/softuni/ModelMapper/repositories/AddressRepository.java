package bg.softuni.ModelMapper.repositories;

import bg.softuni.ModelMapper.entities.Address;
import bg.softuni.ModelMapper.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<Address> findByCountryAndCity(String country, String city);
}
