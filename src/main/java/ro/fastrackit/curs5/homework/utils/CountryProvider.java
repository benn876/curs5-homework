package ro.fastrackit.curs5.homework.utils;

import org.springframework.stereotype.Component;
import ro.fastrackit.curs5.homework.model.Country;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static java.lang.Long.valueOf;
import static java.util.UUID.randomUUID;

@Component
public class CountryProvider {
    public List<Country> readCountries() {
        File file = new File("C:\\projects\\fasttrackIT\\jf02\\curs5-homework\\countries.txt");
        try {
            List<Country> countries = Files.lines(file.toPath()).map(line -> {
                        String[] splitLine = line.split("\\|");
                        return Country.builder()
                                .id(randomUUID().toString())
                                .name(splitLine[0])
                                .capital(splitLine[1])
                                .population(valueOf(splitLine[2]))
                                .area(valueOf(splitLine[3]))
                                .continent(splitLine[4])
                                .neighbours(getNeighbours(splitLine))
                                .build();
                    })
                    .toList();
            return countries;
        } catch (Exception ignored) {
        }

        return List.of();
    }

    private List<String> getNeighbours(String[] splitLine) {
        if (splitLine.length == 5) {
            return List.of();
        }
        return Arrays.stream(splitLine[5].split("~"))
                .toList();
    }
}
