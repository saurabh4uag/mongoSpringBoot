package rc.legostore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.Mongobee;

@SpringBootApplication
public class LegostoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegostoreApplication.class, args);
    }
    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public Mongobee mongobee() {
        Mongobee runner = new Mongobee("mongodb://localhost:27017/legostore");
        runner.setMongoTemplate(mongoTemplate);
        runner.setChangeLogsScanPackage("rc.legostore.persistence");
        return runner;
    }
   

}
