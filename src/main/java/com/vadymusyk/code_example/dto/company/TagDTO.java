package com.vadymusyk.code_example.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO {
    private long tagId;
    private String tag;
}
