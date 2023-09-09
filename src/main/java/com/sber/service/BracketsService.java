package com.sber.service;
import org.springframework.stereotype.Service;
@Service
public class BracketsService {

    public boolean isBracketsBalanced(String text) {
        int balance = 0;
        boolean inside = false;
        for (char c : text.toCharArray()) {
            if (c == '(') {
                balance++;
                inside = false;
            } else if (c == ')') {
                if (balance == 0 || !inside) {
                    return false;
                }
                balance--;
            } else {
                inside = true;
            }
        }
        return balance == 0;
    }
}

