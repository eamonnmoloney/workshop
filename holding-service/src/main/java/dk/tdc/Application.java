package dk.tdc;

import dk.tdc.model.Holdings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/holdings")
    public ResponseEntity<Holdings> home() {
        return ResponseEntity.ok(new Holdings(100d, 10));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
