package com.inu.dimipetition;

import java.io.Serializable;

public class PetitionItem implements Serializable {
    String category;
    String title;
    Integer participant;

    PetitionItem(String category, String title, Integer participant) {
        this.category = category;
        this.title = title;
        this.participant = participant;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public Integer getParticipant() {
        return participant;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParticipant(Integer participant) {
        this.participant = participant;
    }
}
