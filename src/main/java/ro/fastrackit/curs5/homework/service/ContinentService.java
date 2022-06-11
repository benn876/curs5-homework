package ro.fastrackit.curs5.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fastrackit.curs5.homework.model.Country;
import ro.fastrackit.curs5.homework.repository.CountryRepository;
import ro.fastrackit.curs5.homework.utils.CountryFilter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class ContinentService {
    private final CountryRepository repository;

    public List<Country> getAllCountriesForAContinent(String continentName, CountryFilter filter) {

        Stream<Country> stream = repository.findAll().stream()
                .filter(country -> country.continent().equals(continentName));
        if (filter.minPopulation() != null) {
            stream = stream.filter(country -> country.population() > filter.minPopulation());
        }
        return stream.toList();
    }

    public Map<String, List<Country>> getContinentCountries() {
        return repository.findAll().stream()
                .collect(groupingBy(Country::continent));
    }
}
