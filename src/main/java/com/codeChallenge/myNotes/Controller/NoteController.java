package com.codeChallenge.myNotes.Controller;

import com.codeChallenge.myNotes.model.Note;
import com.codeChallenge.myNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping(value = "/notes/{title}", method = RequestMethod.GET)
    public Note getNote(@PathVariable String title) {
        return noteService.getNote(title);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/notes")
    public void addNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/notes/{title}")
    public void updateNote(@RequestBody Note note, @PathVariable String title) {
        noteService.updateNote(title, note);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/notes/{title}")
    public void deleteNote(@RequestBody Note note, @PathVariable String title) {
        noteService.deleteNote(title, note);
    }
}