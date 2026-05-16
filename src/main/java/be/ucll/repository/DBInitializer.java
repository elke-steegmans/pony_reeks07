package be.ucll.repository;

import be.ucll.model.Chicken;
import be.ucll.model.Pony;
import be.ucll.model.Stable;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {

    private PonyRepository ponyRepository;
    private AnimalRepository animalRepository;
    private StableRepository stableRepository;

    public DBInitializer(PonyRepository ponyRepository, AnimalRepository animalRepository, StableRepository stableRepository) {
        this.ponyRepository = ponyRepository;
        this.animalRepository =  animalRepository;
        this.stableRepository = stableRepository;
    }

    @PostConstruct
    public void initialize() {
        Stable stable1 = new Stable();
        Pony bella = new Pony("Bella", 5);
        Pony luna = new Pony("Luna", 7);

        Chicken freddy = new Chicken(true);

        freddy.setStable(stable1);

        Stable stable2 = new Stable();
        bella.setStable(stable2);

        stableRepository.save(stable1);
        stableRepository.save(stable2);

        ponyRepository.save(bella);
        ponyRepository.save(luna);

        animalRepository.save(freddy);

    }


}
