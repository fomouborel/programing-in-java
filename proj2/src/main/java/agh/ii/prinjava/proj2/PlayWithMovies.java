package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     *
     * @param director the name of the director to filter by
     * @return a set of movie titles directed (or co-directed) by the given director
     */
    static Set<String> ex01(String director) {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();

        // Filter the movies by director name and extract only the titles

        return movies.orElseThrow().stream()
                .filter(movie -> movie.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     *
     * @param actor the name of the actor to filter by
     * @return a set of movie titles in which the given actor played
     */
    static Set<String> ex02(String actor) {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();

        // Filter the movies by actor name and extract only the titles

        return movies.orElseThrow().stream()
                .filter(movie -> movie.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .flatMap(movie -> movie.directors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.get().stream()
                .flatMap(movie -> movie.directors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();
        Set<String> topDirectors = ex04().keySet();
        return movies.get().stream()
                .filter(movie -> movie.directors().stream().anyMatch(topDirectors::contains))
                .collect(Collectors.groupingBy(
                        movie -> movie.directors().stream()
                                .filter(topDirectors::contains)
                                .findFirst()
                                .orElseThrow(IllegalStateException::new),
                        Collectors.mapping(Movie::title, Collectors.toSet())
                ));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.get().stream()
                .flatMap(movie -> movie.actors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.get().stream()
                .flatMap(movie -> movie.actors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(9)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        // Load the list of movies from the file
        Optional<List<Movie>> movies = ImdbTop250.movies();
        Set<String> topActors = ex07().keySet();
        return movies.get().stream()
                .filter(movie -> movie.actors().stream().anyMatch(topActors::contains))
                .collect(Collectors.groupingBy(
                        movie -> movie.actors().stream()
                                .filter(topActors::contains)
                                .findFirst()
                                .orElseThrow(IllegalStateException::new),
                        Collectors.mapping(Movie::title, Collectors.toSet())
                ));
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        Optional<List<Movie>> optionalMovies = ImdbTop250.movies();
        List<Movie> movies = optionalMovies.get();

        return movies.stream()
                .filter(movie -> movie.actors().size() >= 2)
                .map(movie -> new ArrayList<>(movie.actors()))
                .map(actors -> {
                    Collections.sort(actors);
                    return actors;
                })
                .flatMap(actors -> IntStream.range(0, actors.size() - 1)
                        .mapToObj(i -> IntStream.range(i + 1, actors.size())
                                .mapToObj(j -> actors.get(i) + " & " + actors.get(j))))
                .flatMap(Function.identity())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }


    static Map<String, Set<String>> ex10() {
        Optional<List<Movie>> optionalMovies = ImdbTop250.movies();
        List<Movie> movies = optionalMovies.get();
        Map<String, Long> actorPairs = ex09();
        return actorPairs.keySet().stream()
                .map(pair -> pair.split(" & "))
                .collect(Collectors.toMap(
                        pair -> pair[0] + " & " + pair[1],
                        pair -> movies.stream()
                                .filter(movie -> movie.actors().equals(pair[0]) && movie.actors().equals(pair[1]))
                                .map(Movie::title)
                                .collect(Collectors.toSet()),
                        (movies1, movies2) -> movies1,
                        LinkedHashMap::new
                ));
    }

}

