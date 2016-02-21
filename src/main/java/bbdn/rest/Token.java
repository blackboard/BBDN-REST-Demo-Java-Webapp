package bbdn.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String access_token;
    private String token_type;
    private String expires_in;

    public Token() {
    }

    public String getToken() {
        return access_token;
    }

    public void setToken(String access_token) {
        this.access_token = access_token;
    }

    public String getType() {
        return token_type;
    }

    public void setType(String token_type) {
        this.token_type = token_type;
    }
    
    public String getExpiry() {
        return expires_in;
    }

    public void setExpiry(String expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access_token=" + access_token + '\'' +
                ", token_type=" + token_type + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
