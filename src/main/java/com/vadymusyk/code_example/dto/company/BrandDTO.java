package com.vadymusyk.code_example.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDTO {

    private long brandId;
    private String name;
}
