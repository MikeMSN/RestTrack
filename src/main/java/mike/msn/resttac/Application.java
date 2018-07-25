package mike.msn.resttac;

import mike.msn.resttac.model.Track;
import mike.msn.resttac.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application {


    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner loadData(TrackRepository trackRepository) {
        return (args) -> {
            trackRepository.save(new Track("Name1", "Description1"));
            trackRepository.save(new Track("Name2", "Description2"));
            trackRepository.save(new Track("Name3", "Description3"));
            trackRepository.save(new Track("Name4", "Description4"));
            /*Car c1 = new Car("rdb1", automatic, AI.enabled, new MaxSpeed(110.12121212, UnitVelocity.mps));
            Car c2 = new Car("rdb2", automatic, AI.disabled, new MaxSpeed(120.967, UnitVelocity.mps));

            Track track = new Track(
                    "Millbrook",
                    "Millbrook city course race track",
                    new Length(7.4, UnitLen.km));

            trackRepository.save(track);

            c1.setTrack(track);
            c2.setTrack(track);
            carRepository.save(c1);
            carRepository.save(c2);*/

        };
    }

}
