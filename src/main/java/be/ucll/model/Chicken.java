package be.ucll.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("chicken")
public class Chicken extends Animal {

    private boolean laysEggs;

    public Chicken(boolean laysEggs) {
        this.laysEggs = laysEggs;
    }

    protected Chicken() {
    }

}
