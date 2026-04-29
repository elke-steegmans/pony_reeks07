package be.ucll.repository;

import be.ucll.model.Pony;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PonyRepositoryOld {

    private List<Pony> ponies = new ArrayList<>();

    public PonyRepositoryOld () {
        reset();
    }

    public List<Pony> getPonies() {
        return ponies;
    }

    public Optional<Pony> findPonyByName(String ponyName) {
        for(Pony pony : ponies) {
            if(pony.getName().equals(ponyName)) {
                return Optional.of(pony);
            }
        }
        return Optional.empty();
    }

//    public Pony findPonyByName(String ponyName) {
//        for(Pony pony : ponies) {
//            if(pony.getName().equals(ponyName)) {
//                return pony;
//            }
//        }
//        return null;
//    }

    public Pony addPony(Pony pony) {
        ponies.add(pony);
        return pony;
    }

    public void reset() {
        ponies.clear();
        ponies.add(new Pony("Bella", 5));
        Pony luna = new Pony("Luna", 7);
        ponies.add(luna);
    }
}
