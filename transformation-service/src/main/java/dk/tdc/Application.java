package dk.tdc;

import dk.tdc.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/print")
    public ResponseEntity<Customer> home() {
        return ResponseEntity.ok(new Customer("foo", "bar"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
