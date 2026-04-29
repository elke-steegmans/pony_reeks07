package be.ucll.service;

import be.ucll.model.Pony;
import be.ucll.repository.PonyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PonyService {

    private PonyRepository ponyRepository;

    public PonyService(PonyRepository ponyRepository) {
        this.ponyRepository = ponyRepository;
    }

    public List<Pony> getAllPonies () {
        return ponyRepository.findAll();
    }

    public Optional<Pony> findPonyByName(String ponyName) {
        return ponyRepository.findByName(ponyName);
    }

//    public Pony addPony(Pony pony) {
//        return ponyRepository.addPony(pony);
//    }
//
//    public Pony updatePony(String name, Pony newDataForExistingPony) {
//        // pony met name opvragen/zoeken
////        Pony foundPony = findPonyByName(name);
////        if (foundPony == null) {
////            throw new RuntimeException("No pony found with this name " + name);
////        }
//        Pony foundPony = findPonyByName(name).orElseThrow(()->new RuntimeException("No pony found with this name " + name));
//        // gevonden pony updaten met new data uit newDataForExistingPony
//        foundPony.setName(newDataForExistingPony.getName());
//        foundPony.setAge(newDataForExistingPony.getAge());
//        return foundPony;
//    }
}
