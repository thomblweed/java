package com.thomblweed.patterns.Flyweight.exercise;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<WordToken> words = new ArrayList<>();

    public Sentence(String plainText) {
        String[] textWords = plainText.trim().split(" ");

        for (int i = 0; i < textWords.length; i++) {
            words.add(new WordToken(textWords[i]));
        }
    }

    public WordToken getWord(int index) {
        return words.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            WordToken word = words.get(i);
            if (word.capitalize) {
                sb.append(word.getWord().toUpperCase());
            } else {
                sb.append(word.getWord());
            }

            if (i < words.size()) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public class WordToken {
        private String word;
        public boolean capitalize;

        public WordToken(String word) {
            this.word = word;
        }

        public String getWord() {
            return this.word;
        }
    }
}
