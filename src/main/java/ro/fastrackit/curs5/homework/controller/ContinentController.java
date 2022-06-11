package ro.fastrackit.curs5.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fastrackit.curs5.homework.model.Country;
import ro.fastrackit.curs5.homework.service.ContinentService;
import ro.fastrackit.curs5.homework.utils.CountryFilter;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("continents")
@RequiredArgsConstructor
public class ContinentController {
    private final ContinentService service;

    @GetMapping("{continentName}/countries")
    public List<Country> getAllCountriesForAContinent(@PathVariable String continentName, CountryFilter filter){
        return service.getAllCountriesForAContinent(continentName,filter);
    }

    @GetMapping("countries")
    public Map<String,List<Country>> getContinentCountries(){
        return service.getContinentCountries();
    }
}
