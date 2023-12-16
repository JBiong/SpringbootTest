package com.acadzen.acadzen.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acadzen.acadzen.Entity.FlashcardEntity;
import com.acadzen.acadzen.Entity.UploadDocumentEntity;
import com.acadzen.acadzen.Repository.UploadDocumentRepository;

@Service
public class FlashcardService {

    @Autowired
    private UploadDocumentRepository drepo;

    // Method to generate flashcards from a document
    public List<FlashcardEntity> generateFlashcards(int documentID) {
        UploadDocumentEntity document = drepo.findById(documentID)
                .orElseThrow(() -> new NoSuchElementException("Document " + documentID + " does not exist"));

        String documentContent = new String(document.getFileContent());
        // Implement logic to parse the document content and generate flashcards
        List<FlashcardEntity> flashcards = generateFlashcardsFromContent(documentContent);

        // Save the generated flashcards to the database or perform any other necessary actions

        return flashcards;
    }

    private List<FlashcardEntity> generateFlashcardsFromContent(String documentContent) {
        // Implement logic to parse the document content and create flashcards
        // For simplicity, let's assume each line in the document is a flashcard
        String[] lines = documentContent.split("\\r?\\n");
        List<FlashcardEntity> flashcards = new ArrayList<>();

        for (String line : lines) {
            FlashcardEntity flashcard = new FlashcardEntity();
            flashcard.setQuestion(line);
            // You might want to set the answer based on your parsing logic
            flashcard.setAnswer("Sample Answer");

            flashcards.add(flashcard);
        }

        return flashcards;
    }
}

