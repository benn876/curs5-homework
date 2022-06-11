package ro.fastrackit.curs5.homework.model;

import lombok.Builder;

import java.util.List;

@Builder
public record Country(String id, String name, String capital, Long population, Long area, String continent,
                      List<String> neighbours) {
}
