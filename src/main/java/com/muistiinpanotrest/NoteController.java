package com.muistiinpanotrest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    private NoteRepository noteRepo;

    @CrossOrigin(origins = {"http://localhost:4200", "https://muistiinpanot.herokuapp.com"})
    @RequestMapping("/note/all")
    public List<Note> getAll() {
        List<Note> notes = (List<Note>) noteService.findAll();
        return notes;
    }

    @CrossOrigin(origins = {"http://localhost:4200", "https://muistiinpanot.herokuapp.com"})
    @RequestMapping(value = "/note", method = RequestMethod.POST)
    public Note addNote(@RequestBody Note note) {
        return this.noteRepo.save(note);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "https://muistiinpanot.herokuapp.com"})
    @RequestMapping(value = "/note", method = RequestMethod.DELETE)
    public void removeNote(@RequestParam("id") String itemid) {
        int id = Integer.parseInt(itemid);
        Optional<Note> note = this.noteRepo.findById(id);
        note.ifPresent(n -> this.noteRepo.delete(n));
    }
}