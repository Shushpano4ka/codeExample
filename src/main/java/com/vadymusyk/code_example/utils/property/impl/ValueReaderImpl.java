package com.vadymusyk.code_example.utils.property.impl;

import com.vadymusyk.code_example.utils.property.ValueReader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by vadymusyk on 08.08.17.
 */
@Component
@Getter
@Setter
@NoArgsConstructor
public class ValueReaderImpl implements ValueReader {

    @Value("${server.url.local}")
    private String localServerUrl;

    @Value("${server.url.remote}")
    private String remoteServerUrl;

    @Autowired
    private Environment environment;

    @Override
    public String getServerPath() {
        return environment.getActiveProfiles()[0].equals("dev") ? localServerUrl : remoteServerUrl;
    }
}
