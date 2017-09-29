package com.vadymusyk.code_example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


@Configuration
@Profile("dev")
public class Oauth2ServerConfiguration {

    private static InMemoryTokenStore tokenStore = new InMemoryTokenStore();

    private static final String SERVER_RESOURCE_ID = "oauth2-server";

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Configuration
    @EnableResourceServer
    protected static class AccountAuthenticationConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.tokenStore(tokenStore).resourceId(SERVER_RESOURCE_ID);
        }


        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/**")
                    .csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET,
                            "/api/department/**", "/api/company", "/api/brand", "/api/category/**", "/api/comment**", "/api/comment/**")
                    .permitAll()
                    .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/**", "/api/registration/**", "/image**")
                    .permitAll()
                    .antMatchers(HttpMethod.POST, "/api/user/department",
                            "/api/comment**")
                    .hasAnyAuthority("USER", "OWNER")
                    .antMatchers(HttpMethod.PUT, "/api/user/department**",
                            "/api/user/department/**")
                    .hasAnyAuthority("OWNER")
                    .antMatchers(HttpMethod.POST, "/api/user/moderator", "/api/comment**",
                            "/api/comment/**", "/api/brand/**", "/api/brand**", "/api/department/type",
                            "/api/category**", "/api/category/**")
                    .hasAnyAuthority("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/api/brand/**", "/api/brand**", "/api/department/type", "/api/department/{departmentId}/moderate**", "/api/category**", "/api/category/**")
                    .hasAnyAuthority("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/api/user/moderator", "/api/brand/**", "/api/brand**", "/api/department/type")
                    .hasAnyAuthority("ADMIN")
                    .anyRequest()
                    .access("#oauth2.hasScope('openid')");
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

        @Qualifier("authenticationManagerBean")
        private final AuthenticationManager authenticationManager;

        @Autowired
        public OAuthConfiguration(AuthenticationManager authenticationManager) {
            this.authenticationManager = authenticationManager;
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients
                    .inMemory()
                    .withClient("acme")
                    .secret("*****")
                    .scopes("openid")
                    .resourceIds(SERVER_RESOURCE_ID)
                    .authorizedGrantTypes(
                            "authorization_code", "refresh_token", "password");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(this.authenticationManager).tokenStore(tokenStore).approvalStoreDisabled();
        }

    }
}
