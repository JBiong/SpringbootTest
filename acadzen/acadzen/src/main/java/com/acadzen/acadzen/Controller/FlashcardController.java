package com.acadzen.acadzen.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acadzen.acadzen.Entity.FlashcardEntity;
import com.acadzen.acadzen.Service.FlashcardService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/flashcard")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @PutMapping("/generate/{documentID}")
    public ResponseEntity<List<FlashcardEntity>> generateFlashcards(@PathVariable int documentID) {
        List<FlashcardEntity> generatedFlashcards = flashcardService.generateFlashcards(documentID);
        return ResponseEntity.ok(generatedFlashcards);
    }
}

