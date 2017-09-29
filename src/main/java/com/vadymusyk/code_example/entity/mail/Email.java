package com.vadymusyk.code_example.entity.mail;

import lombok.*;

/**
 * Created by vadymusyk on 13.07.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {
    private String to;

    private String subject;

    private String message;

    private boolean isHtml;
}
