package com.company.customerinfo;


import com.company.customerinfo.config.AuthenticationProperties;
import com.company.customerinfo.config.Directory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Map;


@SpringBootTest(classes = CustomerInfoApplication.class)
@ContextConfiguration(classes = AuthenticationProperties.class)
@TestPropertySource("classpath:/authentication/authentication-dev.properties")
public class AuthenticationPropertiesFileTest {

    @Autowired
    AuthenticationProperties authenticationProperties;

    @Test
    public void givenAuthenticationPropertiesFile_whenFileIsNotEmpty_thenReadContent() {

        String username = authenticationProperties.getUsername();
        String password = authenticationProperties.getPassword();
        List<Boolean> enabledPorts = authenticationProperties.getEnabledports();
        Map<String,Boolean> additionalRights = authenticationProperties.getAdditionalRights();
        Directory directory = authenticationProperties.getDirectory();

        Assertions.assertThat(username).isEqualTo("user");
        Assertions.assertThat(password).isEqualTo("password");
        Assertions.assertThat(enabledPorts).isNotNull();
        Assertions.assertThat(enabledPorts).isNotEmpty();
        Assertions.assertThat(enabledPorts.size()).isGreaterThan(0);
        Assertions.assertThat(enabledPorts.get(0)).isEqualTo(true);
        Assertions.assertThat(enabledPorts.get(1)).isEqualTo(false);
        Assertions.assertThat(additionalRights).isNotNull();
        Assertions.assertThat(additionalRights).isNotEmpty();
        Assertions.assertThat(additionalRights.size()).isGreaterThan(0);
        Assertions.assertThat(additionalRights.containsKey("read")).isTrue();
        Assertions.assertThat(directory).isNotNull();
        Assertions.assertThat(directory.getPath()).isEqualTo("C:\\root");
        Assertions.assertThat(directory.isListing()).isTrue();
    }


}
