package com.github.scribejava.apis.openid;

import com.github.scribejava.core.extractors.OAuth2AccessTokenJsonExtractor;
import java.util.Map;

/**
 * additionally parses OpenID id_token
 */
public class OpenIdJsonTokenExtractor extends OAuth2AccessTokenJsonExtractor {

    protected OpenIdJsonTokenExtractor() {
    }

    private static class InstanceHolder {

        private static final OpenIdJsonTokenExtractor INSTANCE = new OpenIdJsonTokenExtractor();
    }

    public static OpenIdJsonTokenExtractor instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    protected OpenIdOAuth2AccessToken createToken(String accessToken, String tokenType, Integer expiresIn,
            String refreshToken, String scope, Map<String, String> response, String rawResponse) {
        return new OpenIdOAuth2AccessToken(accessToken, tokenType, expiresIn, refreshToken, scope,
                response.get("id_token"), rawResponse);
    }
}
