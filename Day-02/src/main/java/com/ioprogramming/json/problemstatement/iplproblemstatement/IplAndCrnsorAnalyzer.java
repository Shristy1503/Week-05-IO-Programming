package com.ioprogramming.json.problemstatement.iplproblemstatement;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

class IPLMatch {
    public int match_id;
    public String team1;
    public String team2;
    public int score_team1;
    public int score_team2;
    public String winner;
    public String player_of_match;

    public IPLMatch() {}

    @Override
    public String toString() {
        return "Match ID: " + match_id +
                ", Team1: " + team1 +
                ", Team2: " + team2 +
                ", Score: " + score_team1 + " - " + score_team2 +
                ", Winner: " + winner +
                ", Player of Match: " + player_of_match;
    }
}

public class IplAndCrnsorAnalyzer {
    public static void main(String[] args) {
        String jsonInputFile = "ipl_matches.json";
        String csvInputFile = "ipl_matches.csv";
        String jsonOutputFile = "ipl_matches_censored.json";
        String csvOutputFile = "ipl_matches_censored.csv";

        try {
            List<IPLMatch> matches = readJsonFile(jsonInputFile);
            List<IPLMatch> sanitizedMatches = applyCensorship(matches);
            writeJsonFile(sanitizedMatches, jsonOutputFile);

            matches = readCsvFile(csvInputFile);
            sanitizedMatches = applyCensorship(matches);
            writeCsvFile(sanitizedMatches, csvOutputFile);

            System.out.println("Censorship completed. Output files generated.");
        } catch (Exception e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    public static List<IPLMatch> readJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<IPLMatch>>() {});
    }

    public static void writeJsonFile(List<IPLMatch> matches, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }

    public static List<IPLMatch> readCsvFile(String filePath) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(IPLMatch.class).withHeader();

        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("CSV file not found: " + filePath);
        }

        MappingIterator<IPLMatch> it = csvMapper.readerFor(IPLMatch.class)
                .with(schema)
                .readValues(file);

        return it.readAll();
    }


    public static void writeCsvFile(List<IPLMatch> matches, String filePath) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(IPLMatch.class).withHeader();

        csvMapper.writer(schema).writeValue(new File(filePath), matches);
    }

    public static List<IPLMatch> applyCensorship(List<IPLMatch> matches) {
        for (IPLMatch match : matches) {
            match.team1 = maskTeamName(match.team1);
            match.team2 = maskTeamName(match.team2);
            match.winner = maskTeamName(match.winner);
            match.player_of_match = "REDACTED";
        }
        return matches;
    }

    public static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
            return String.join(" ", words);
        }
        return teamName;
    }
}


