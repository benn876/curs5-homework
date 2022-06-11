package ro.fastrackit.curs5.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fastrackit.curs5.homework.model.Country;
import ro.fastrackit.curs5.homework.repository.CountryRepository;
import ro.fastrackit.curs5.homework.utils.CountryFilter;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public List<Country> getAll(CountryFilter filter) {
        Stream<Country> countries = repository.findAll().stream();

        if (filter.excludeNeighbour() != null) {
            countries = countries.filter(country -> !country.neighbours().contains(filter.excludeNeighbour()));
        }
        if (filter.includeNeighbour() != null) {
            countries = countries.filter(country -> country.neighbours().contains(filter.includeNeighbour()));
        }
        return countries.toList();
    }

    public List<String> getAllCountryNames() {
        return repository.findAll().stream()
                .map(Country::name)
                .toList();
    }

    public String getCapital(String id) {
        return repository.findById(id)
                .capital();
    }

    public Long getPopulation(String id) {
        return repository.findById(id).population();
    }

    public List<String> getNeighbours(String id) {
        return repository.findById(id)
                .neighbours();
    }

    public Map<Long, List<Country>> getCountriesPopulation() {
        return repository.findAll().stream()
                .collect(groupingBy(Country::population));
    }
}
