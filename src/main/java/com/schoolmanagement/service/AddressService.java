package com.schoolmanagement.service;

import com.schoolmanagement.dto.AddressDTO;
import com.schoolmanagement.entity.Address;
import com.schoolmanagement.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Optional<AddressDTO> getByStudentId(Long studentId) {
        return addressRepository.findByStudentId(studentId).map(this::toDto);
    }

    private AddressDTO toDto(Address a) {
        AddressDTO dto = new AddressDTO();
        dto.setStudentId(a.getStudentId());
        dto.setStreet(a.getStreet());
        dto.setCity(a.getCity());
        dto.setZip(a.getZip());
        return dto;
    }
    public AddressDTO createAddress(AddressDTO dto) {
        Address address = Address.builder()
                .studentId(dto.getStudentId())
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .zip(dto.getZip())
                .build();
        Address saved = addressRepository.save(address);
        dto.setId(saved.getId());
        return dto;
    }

}
