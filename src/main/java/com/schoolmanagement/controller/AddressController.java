package com.schoolmanagement.controller;


import com.schoolmanagement.dto.AddressDTO;
import com.schoolmanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public AddressDTO create(@RequestBody AddressDTO dto) {
        return addressService.createAddress(dto);
    }

    @GetMapping("/student/{studentId}")
    public Optional<AddressDTO> getByStudentId(@PathVariable Long studentId) {
        return addressService.getByStudentId(studentId);
    }
}
