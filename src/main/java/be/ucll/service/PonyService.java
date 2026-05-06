package be.ucll.service;

import be.ucll.model.Owner;
import be.ucll.model.Pony;
import be.ucll.repository.OwnerRepository;
import be.ucll.repository.PonyRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PonyService {

    private OwnerRepository ownerRepository;
    private PonyRepository ponyRepository;

    public PonyService(PonyRepository ponyRepository, OwnerRepository ownerRepository) {
        this.ponyRepository = ponyRepository;
        this.ownerRepository = ownerRepository;
    }

    public List<Pony> getAllPonies () {
        return ponyRepository.findAll();
    }

    public Optional<Pony> findPonyByName(String ponyName) {
        return ponyRepository.findByName(ponyName);
    }

    public Pony addOwnerToPony(String ponyName, @Valid Owner bram) {
        Pony foundPony = findPonyByName(ponyName).get();
        ownerRepository.save(bram);
        foundPony.setOwner(bram);
        ponyRepository.save(foundPony);
        return foundPony;
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
