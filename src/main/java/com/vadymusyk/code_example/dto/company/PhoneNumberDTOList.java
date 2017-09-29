package com.vadymusyk.code_example.dto.company;

import com.vadymusyk.code_example.validator.phoneNumber.DepartmentNumbersConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadymusyk on 17.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberDTOList {

    @DepartmentNumbersConstraint
    private List<PhoneNumberDTO> phoneNumbers = new ArrayList<>();
}
