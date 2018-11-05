package dk.tdc;

import dk.tdc.model.Advisor;
import dk.tdc.model.Customer;
import dk.tdc.model.Document;
import dk.tdc.model.Holdings;
import dk.tdc.service.DatabaseService;
import dk.tdc.simulation.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
@RestController
public class Application {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/simulation")
    public ResponseEntity<Simulation> customer() {
        Simulation simulation = new Simulation();
        simulation.setHoldings(restTemplate.getForEntity("http://holdings-service:8080/holdings", Holdings.class).getBody());
        simulation.setAdvisor(restTemplate.getForEntity("http://advisor-service:8080/advisor", Advisor.class).getBody());
        simulation.setCustomer(restTemplate.getForEntity("http://customer-service:8080/customer", Customer.class).getBody());
        return ResponseEntity.ok(simulation);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> home() {
        Simulation simulation = new Simulation();
        simulation.setHoldings(restTemplate.getForEntity("http://holdings-service:8080/holdings", Holdings.class).getBody());
        simulation.setAdvisor(restTemplate.getForEntity("http://advisor-service:8080/advisor", Advisor.class).getBody());
        simulation.setCustomer(restTemplate.getForEntity("http://customer-service:8080/customer", Customer.class).getBody());

        ResponseEntity<Document> documentResponseEntity = restTemplate.postForEntity("http://transformation-service:8080/print", simulation, Document.class);

        databaseService.save(documentResponseEntity.getBody());
        return ResponseEntity.ok().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
