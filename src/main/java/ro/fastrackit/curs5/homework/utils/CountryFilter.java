package ro.fastrackit.curs5.homework.utils;

import lombok.Builder;

@Builder
public record CountryFilter(Long minPopulation, String includeNeighbour, String excludeNeighbour) {
}
