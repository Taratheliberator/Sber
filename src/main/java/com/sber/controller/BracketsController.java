package com.sber.controller;

import com.sber.service.BracketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BracketsController {

    private final BracketsService service;


    @Autowired
    public BracketsController(BracketsService service) {
        this.service = service;
    }

    @PostMapping("/checkBrackets")
    public ResponseEntity<Result> checkBrackets(@RequestBody TextRequest request) {
        if (request == null || request.getText() == null || request.getText().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(new Result(false));
        }

        boolean isBalanced = service.isBracketsBalanced(request.getText());
        return ResponseEntity.ok(new Result(isBalanced));
    }

    public static class Result {
        private boolean isCorrect;

        public Result(boolean isCorrect) {
            this.isCorrect = isCorrect;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public void setCorrect(boolean isCorrect) {
            this.isCorrect = isCorrect;
        }
    }

    public static class TextRequest {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
