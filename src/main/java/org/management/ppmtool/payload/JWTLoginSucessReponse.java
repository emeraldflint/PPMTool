package org.management.ppmtool.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class JWTLoginSucessReponse {
    private boolean success;
    private String token;
}
