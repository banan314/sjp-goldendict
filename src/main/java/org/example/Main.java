package org.example;

import sjpapi.api.SjpAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String NAME_FORMAT = "<span style='font-size: large'><b>%s</b></span>";
    private static final String MEANING_FORMAT = "<font color=grey>%s</font>";

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("You need to give me a term to look up.");
            return;
        }

        var word = args[0];
        var wordJson = SjpAPI.getWordJSON(word);

        System.out.println(
                String.format(NAME_FORMAT, wordJson.getName()) +
                        String.format(MEANING_FORMAT, String.join("", formatMeanings(wordJson.getMeaning())))
        );
    }

    private static List<String> formatMeanings(List<String> meaning) {
        // split each meaning into a separate line where digit dot occurs
        var meanings = new ArrayList<>(meaning.stream()
                .map(m -> m.split("(?=\\d\\.)"))
                .flatMap(m -> {
                    var list = new ArrayList<>(List.of("<br><br>"));

                    // add <br> to each element in m except the last one
                    list.addAll(Arrays.stream(m, 0, m.length - 1)
                            .map(s -> s + "<br>")
                            .toList());
                    // add the last element in m
                    list.add(m[m.length - 1]);

                    return list.stream();
                })
                .map(String::trim)
                .toList());

        // make the number in front of the meanings consecutive in all cases
        var currentIndex = 1;
        for(var i = 0; i < meanings.size(); i++) {
            var currentMeaning = meanings.get(i);

            // match the number in front of the meaning, regex includes extended characters like \n
            if(currentMeaning.matches("(?s)\\d\\..*")) {
                meanings.set(i, currentIndex + currentMeaning.substring(1));
                currentIndex++;
            }
        }

        // remove blank meanings
        meanings.removeIf(String::isBlank);

        return meanings;
    }
}