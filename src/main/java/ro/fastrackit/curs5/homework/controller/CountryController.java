package ro.fastrackit.curs5.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fastrackit.curs5.homework.model.Country;
import ro.fastrackit.curs5.homework.service.CountryService;
import ro.fastrackit.curs5.homework.utils.CountryFilter;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("countries")
public class CountryController {

    private final CountryService service;

    @GetMapping
    public List<Country> getAll(CountryFilter filter) {
        return service.getAll(filter);
    }

    @GetMapping("names")
    public List<String> getAllCountryNames() {
        return service.getAllCountryNames();
    }

    @GetMapping("{id}/capital")
    public String getCapital(@PathVariable String id) {
        return service.getCapital(id);
    }

    @GetMapping("{id}/population")
    public Long getPopulation(@PathVariable String id) {
        return service.getPopulation(id);
    }

    @GetMapping("{id}/neighbours")
    public List<String> getNeighbours(@PathVariable String id) {
        return service.getNeighbours(id);
    }

    @GetMapping("/population")
    public Map<Long, List<Country>> getCountriesPopulation() {
        return service.getCountriesPopulation();
    }

}
