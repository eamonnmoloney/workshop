package dk.tdc;

import dk.tdc.model.Advisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/advisor")
    public ResponseEntity<Advisor> home() {
        return ResponseEntity.ok(new Advisor("quk", "quz"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
