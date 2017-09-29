package com.vadymusyk.code_example.converter.company.properties;

import com.vadymusyk.code_example.dto.company.PhoneNumberDTO;
import com.vadymusyk.code_example.entity.company.contacts.PhoneNumber;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 17.08.17.
 */
public class PhoneNumberConverter {
    public static List<PhoneNumberDTO> toDTOList(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream()
                .map(PhoneNumberConverter::toDTO)
                .collect(Collectors.toList());
    }

    private static PhoneNumberDTO toDTO(PhoneNumber phoneNumber) {
        return new PhoneNumberDTO(phoneNumber.getPriority(), phoneNumber.getNumber());
    }
}
