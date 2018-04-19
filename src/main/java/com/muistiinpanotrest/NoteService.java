package com.muistiinpanotrest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public List<Note> findAll() {
        List<Note> cities = (List<Note>) repository.findAll();
        return cities;
    }
}