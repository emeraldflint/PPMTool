package org.management.ppmtool.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JWTLoginSucessReponse {
    private boolean success;
    private String token;
}
