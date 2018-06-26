package com.oreillyauto.projecttemplate.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.oreillyauto.projecttemplate.dao.AnimalClassRepository;
import com.oreillyauto.projecttemplate.dao.AnimalRepository;
import com.oreillyauto.projecttemplate.dao.ContinentRepository;
import com.oreillyauto.projecttemplate.domain.Animal;
import com.oreillyauto.projecttemplate.domain.AnimalClass;
import com.oreillyauto.projecttemplate.domain.Continent;
import com.oreillyauto.projecttemplate.dto.Search;
import com.oreillyauto.projecttemplate.service.SearchService;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

    private static final String CONTINENT = "continent";

    private static final String CLASS = "class";

    private static final String DESC = "desc";

    private static final String ASC = "asc";

    private static final String NAME = "name";

    private static final String LEG_COUNT_LABEL = "Leg Count";

    private static final String POPULATION_SIZE_LABEL = "Population Size";

    private static final String CONTINENT_LABEL = "Continent";

    private static final String LAST_SEARCH = "lastSearch";

    private static final String HIGH = "high";

    private static final String LOW = "low";

    private static final String SEARCH_TYPE = "searchType";

    private static final String CONTINENT_LIST = "continentList";

    private static final String ANIMAL_LIST = "animalList";

    private static final String LEG_COUNT = "legCount";

    private static final String POPULATION_SIZE = "populationSize";

    private static final String CONTINENT_NAME = "continentName";

    private static final String RESULT_LABEL = "resultLabel";

    private static final String ACTIVE = "active";

    private static final String ANIMAL = "animal";

    private static final String ANIMAL_NAME = "animalName";

    @Autowired
    AnimalRepository animalRepo;

    @Autowired
    AnimalClassRepository animalClassRepo;

    @Autowired
    ContinentRepository continentRepo;

    @Override
    public void search(HttpSession session, Model model, Search search) {

        Animal animal = search.getAnimal();
        AnimalClass animalClass = search.getAnimalClass();
        Continent continent = search.getContinent();

        String searchType = search.getSearchType();
        String animalName = animal.getName();
        String continentName = search.getContinent().getName();
        String searchKey = getSearchKey(search);
        String searchValue = getSearchValue(search);
        String lastSearch = search.getLastSearch();

        Long low = search.getLow();
        Long high = search.getHigh();
        model.addAttribute(SEARCH_TYPE, search.getSearchType());
        model.addAttribute(ANIMAL_NAME, animalName);
        model.addAttribute(CONTINENT_NAME, continent.getName());
        List<Animal> animalList = new ArrayList<Animal>();

        if (low != null) {
            session.setAttribute(LOW, low);
        }

        if (high != null) {
            session.setAttribute(HIGH, high);
        }

        switch (searchType) {

            case ANIMAL_NAME:
                model.addAttribute(RESULT_LABEL, "Search By Animal Name: " + animal.getName());
                animalName = (animal.getName() == null) ? "" : animal.getName().toLowerCase();
                animal = animalRepo.getAnimalByName(animalName);
                model.addAttribute(ANIMAL, animal);
                model.addAttribute(ACTIVE, animalName);
                break;

            case CONTINENT_NAME:
                model.addAttribute(RESULT_LABEL, "Search By Continent: " + continent.getName());
                continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                animalList = animalRepo.getAnimalsByContinent(continentName, null, null);
                model.addAttribute(ANIMAL_LIST, animalList);
                model.addAttribute(LAST_SEARCH, CONTINENT_NAME);
                break;

            case POPULATION_SIZE:
                model.addAttribute(RESULT_LABEL, "Continent By Population: '" + low + "' to '" + high + "'");

                if (low != null && high != null && low <= high) {
                    List<Continent> continentList = continentRepo.getContinentsByPopulation(low, high);
                    model.addAttribute(CONTINENT_LIST, continentList);
                } else {
                    model.addAttribute(CONTINENT_LIST, Collections.emptyList());
                }

                model.addAttribute(LAST_SEARCH, POPULATION_SIZE);
                break;

            case LEG_COUNT:
                Long legCount = search.getLow();
                model.addAttribute(RESULT_LABEL, "Animal By Leg Count: " + legCount);

                if (low != null) {
                    animalList = animalRepo.getAnimalsByLegCount(search.getLow(), null, null);
                    model.addAttribute(ANIMAL_LIST, animalList);
                } else {
                    model.addAttribute(ANIMAL_LIST, Collections.emptyList());
                }

                model.addAttribute(LAST_SEARCH, LEG_COUNT);
                model.addAttribute(LEG_COUNT, legCount);
                break;

            case "animalNameAsc":
                model.addAttribute(RESULT_LABEL, "Search By " + searchKey + ": " + searchValue + " (Name Asc)");

                if (CONTINENT_NAME.equals(lastSearch)) {
                    continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                    animalList = animalRepo.getAnimalsByContinent(continentName, NAME, ASC);
                } else if (LEG_COUNT.equals(lastSearch)) {
                    legCount = search.getLow();
                    animalList = animalRepo.getAnimalsByLegCount(legCount, NAME, ASC);
                }

                model.addAttribute(ANIMAL_LIST, animalList);
                break;

            case "animalNameDesc":
                model.addAttribute(RESULT_LABEL, "Search By " + searchKey + ": " + searchValue + " (Name Desc)");

                if (CONTINENT_NAME.equals(lastSearch)) {
                    continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                    animalList = animalRepo.getAnimalsByContinent(continentName, NAME, DESC);
                } else if (LEG_COUNT.equals(lastSearch)) {
                    legCount = search.getLow();
                    animalList = animalRepo.getAnimalsByLegCount(legCount, NAME, DESC);
                }

                model.addAttribute(ANIMAL_LIST, animalList);
                break;

            case "animalClassAsc":
                model.addAttribute(RESULT_LABEL, "Search By " + searchKey + ": " + searchValue + " (Class Asc)");

                if (CONTINENT_NAME.equals(lastSearch)) {
                    continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                    animalList = animalRepo.getAnimalsByContinent(continentName, CLASS, ASC);
                } else if (LEG_COUNT.equals(lastSearch)) {
                    legCount = search.getLow();
                    animalList = animalRepo.getAnimalsByLegCount(legCount, CLASS, ASC);
                }

                model.addAttribute(ANIMAL_LIST, animalList);
                break;

            case "animalClassDesc":
                model.addAttribute(RESULT_LABEL, "Search By " + searchKey + ": " + searchValue + " (Class Desc)");

                if (CONTINENT_NAME.equals(lastSearch)) {
                    continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                    animalList = animalRepo.getAnimalsByContinent(continentName, CLASS, DESC);
                } else if (LEG_COUNT.equals(lastSearch)) {
                    legCount = search.getLow();
                    animalList = animalRepo.getAnimalsByLegCount(legCount, CLASS, DESC);
                }

                model.addAttribute(ANIMAL_LIST, animalList);
                break;

            case "continentAsc":
                model.addAttribute(RESULT_LABEL, "Search By " + searchKey + ": " + searchValue + " (Cont. Asc)");

                if (CONTINENT_NAME.equals(lastSearch)) {
                    continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                    animalList = animalRepo.getAnimalsByContinent(continentName, CONTINENT, ASC);
                } else if (LEG_COUNT.equals(lastSearch)) {
                    legCount = search.getLow();
                    animalList = animalRepo.getAnimalsByLegCount(legCount, CONTINENT, ASC);
                }

                model.addAttribute(ANIMAL_LIST, animalList);
                break;

            case "continentDesc":
                model.addAttribute(RESULT_LABEL, "Search By " + searchKey + ": " + searchValue + " (Cont. Desc)");

                if (CONTINENT_NAME.equals(lastSearch)) {
                    continentName = (continent.getName() == null) ? "" : continent.getName().toLowerCase();
                    animalList = animalRepo.getAnimalsByContinent(continentName, CONTINENT, DESC);
                } else if (LEG_COUNT.equals(lastSearch)) {
                    legCount = search.getLow();
                    animalList = animalRepo.getAnimalsByLegCount(legCount, CONTINENT, DESC);
                }

                model.addAttribute(ANIMAL_LIST, animalList);
                break;

            default:
                model.addAttribute(RESULT_LABEL, "Invalid Search");
                break;
        }
    }

    private String getSearchValue(Search search) {
        String searchValue = "";
        String lastSearch = search.getLastSearch();

        if (!StringUtils.hasText(lastSearch)) {
            return "";
        }

        switch (lastSearch) {
            case CONTINENT_NAME:
                searchValue = search.getContinent().getName();
                break;
            case POPULATION_SIZE:
                searchValue = search.getLow() + " - " + search.getHigh();
                break;
            case LEG_COUNT:
                searchValue = String.valueOf(search.getLow());
                break;
        }

        return searchValue;
    }

    private String getSearchKey(Search search) {
        String searchKey = "";
        String lastSearch = search.getLastSearch();

        if (!StringUtils.hasText(lastSearch)) {
            return "";
        }

        switch (lastSearch) {
            case CONTINENT_NAME:
                searchKey = CONTINENT_LABEL;
                break;
            case POPULATION_SIZE:
                searchKey = POPULATION_SIZE_LABEL;
                break;
            case LEG_COUNT:
                searchKey = LEG_COUNT_LABEL;
                break;
        }

        return searchKey;
    }

    @Override
    public Animal getAnimalByName(String animalName) {
        return animalRepo.getAnimalByName(animalName);
    }

    @Override
    public AnimalClass getAnimalClassByClassName(String animalClassName) {
        return animalClassRepo.getAnimalClassByClassName(animalClassName);
    }

    @Override
    public List<Animal> getAnimalsByContinent(String continentName) {
        return animalRepo.getAnimalsByContinent(continentName, null, null);
    }

    @Override
    public List<Continent> getContinentsByPopulation(Integer low, Integer high) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Animal> getAnimalsByLegCount(Integer count) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Animal> getAnimalByNameAsc(String animalName, String direction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Animal> getAnimalClassByClassName(String animalClassName, String direction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Continent> getContientsByNameOrderByName(String continentName, String direction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Continent> getContientsByNameOrderByPopulation(String continentName, String direction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Continent> getContientsByNameOrderByArea(String continentName, String direction) {
        // TODO Auto-generated method stub
        return null;
    }

}
