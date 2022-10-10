package Cryptanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = Files.readString(Path.of(args[1], ""));
        int key = Integer.parseInt(args[2]);

        if ("encode".equalsIgnoreCase(args[0])) {

            String outPath1 = args[1];
            String outPath2 = outPath1.replaceAll("Hamlet.txt", "Hamlet_encoded.txt");
            Path outFilePath = Path.of(outPath2, "");

            String encoded = Encode.encode(text, key);
            Files.writeString(outFilePath, encoded);

        } else if ("decode".equalsIgnoreCase(args[0])) {

            String outPath1 = args[1];
            String outPath2 = outPath1.replaceAll( "Hamlet.txt","Hamlet_encoded.txt");
            String outPath3 = outPath2.replaceAll("Hamlet_encoded.txt", "Hamlet_decoded.txt");
            Path outFilePath = Path.of(outPath3, "");
            String decoded = Decode.decode(text, key);
            Files.writeString(outFilePath, decoded);
        }
    }
}
