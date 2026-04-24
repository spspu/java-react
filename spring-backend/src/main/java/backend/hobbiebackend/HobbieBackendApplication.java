package backend.hobbiebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HobbieBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobbieBackendApplication.class, args);
        
        
      //key generate though main method
//		SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
//		String secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
//		System.out.println("JWT Secret Key:");
//		System.out.println(secretKey);
    }

}
