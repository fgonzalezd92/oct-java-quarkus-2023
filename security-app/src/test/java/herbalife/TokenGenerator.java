package herbalife;

import io.smallrye.jwt.build.Jwt;

import java.util.Arrays;
import java.util.HashSet;

public class TokenGenerator {
    public static void main(String[] args) {
        System.setProperty("smallrye.jwt.sign.key.location", "privateKey.pem");
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .upn("sam@yahoo.com")
                        .groups(new HashSet<>(Arrays.asList("user", "admin")))
                        .sign();
        System.out.println(token);
    }
}
