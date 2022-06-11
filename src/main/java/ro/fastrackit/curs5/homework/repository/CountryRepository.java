package ro.fastrackit.curs5.homework.repository;

import org.springframework.stereotype.Component;
import ro.fastrackit.curs5.homework.model.Country;
import ro.fastrackit.curs5.homework.utils.CountryProvider;

import java.util.List;

@Component
public class CountryRepository {
    private final List<Country> countries;

    public CountryRepository(CountryProvider countryProvider) {
        this.countries = countryProvider.readCountries();
    }


    public List<Country> findAll() {
        return countries;
    }

    public Country findById(String id) {
        return countries.stream()
                .filter(country -> country.id().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
