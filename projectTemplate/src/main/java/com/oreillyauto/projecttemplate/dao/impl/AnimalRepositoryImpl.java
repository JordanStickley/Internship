package com.oreillyauto.projecttemplate.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.oreillyauto.projecttemplate.dao.custom.AnimalRepositoryCustom;
import com.oreillyauto.projecttemplate.domain.Animal;
import com.oreillyauto.projecttemplate.domain.AnimalClass;
import com.oreillyauto.projecttemplate.domain.QAnimal;
import com.oreillyauto.projecttemplate.domain.QAnimalClass;
import com.oreillyauto.projecttemplate.domain.QContinent;
import com.querydsl.core.types.OrderSpecifier;

@Repository
public class AnimalRepositoryImpl extends QuerydslRepositorySupport implements AnimalRepositoryCustom {

    private static final String CONTINENT = "continent";
    private static final String DESC = "desc";
    private static final String CLASS = "class";

    public AnimalRepositoryImpl() {
        super(Animal.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Animal getAnimalByName(String animalName) {
        QAnimal animal = QAnimal.animal;

        List<Animal> animalList = (List<Animal>) (Object) getQuerydsl().createQuery()
                .from(animal)
                .where(animal.name.eq(animalName))
                .fetch();

        if (animalList != null & animalList.size() > 0) {
            return animalList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Animal> getAnimalsByContinent(String continentName, String orderBy, String direction) {
        QAnimal animal = QAnimal.animal;
        List<Animal> animalList = new ArrayList<Animal>();

        if (CLASS.equalsIgnoreCase(orderBy)) {
            // Animal Class Name
            if (DESC.equalsIgnoreCase(direction)) {
                animalList = getAnimalsByContinentOrdered(continentName, animal.animalClass.className.desc());
            } else {
                animalList = getAnimalsByContinentOrdered(continentName, animal.animalClass.className.asc());
            }
        } else if (CONTINENT.equalsIgnoreCase(orderBy)) {
            // Continent
            if (DESC.equalsIgnoreCase(direction)) {
                animalList = getAnimalsByContinentOrdered(continentName, animal.continentName.desc());
            } else {
                animalList = getAnimalsByContinentOrdered(continentName, animal.continentName.asc());
            }
        } else {
            // Animal Name
            if (DESC.equalsIgnoreCase(direction)) {
                animalList = getAnimalsByContinentOrdered(continentName, animal.name.desc());
            } else {
                animalList = getAnimalsByContinentOrdered(continentName, animal.name.asc());
            }
        }

        if (animalList != null & animalList.size() > 0) {
            return animalList;
        } else {
            return Collections.emptyList();
        }
    }

    @SuppressWarnings("unchecked")
    private List<Animal> getAnimalsByContinentOrdered(String continentName, OrderSpecifier<?> orderSpecifier) {
        QAnimal animal = QAnimal.animal;
        return (List<Animal>) (Object) getQuerydsl().createQuery()
                .from(animal)
                .where(animal.continentName.toLowerCase().eq(continentName.toLowerCase()))
                .orderBy(orderSpecifier)
                .fetch();
    }

    @SuppressWarnings("unchecked")
    private List<Animal> getAnimalsByLegCountOrdered(Long legCount, OrderSpecifier<?> orderSpecifier) {
        QAnimal animal = QAnimal.animal;
        return (List<Animal>) (Object) getQuerydsl().createQuery()
                .from(animal)
                .where(animal.legCount.eq(String.valueOf(legCount)))
                .orderBy(orderSpecifier)
                .fetch();
    }

    @Override
    public List<Animal> getAnimalsByLegCount(Long legCount, String orderBy, String direction) {
        QAnimal animal = QAnimal.animal;
        List<Animal> animalList = new ArrayList<Animal>();

        if (CLASS.equalsIgnoreCase(orderBy)) {
            // Animal Class Name
            if (DESC.equalsIgnoreCase(direction)) {
                animalList = getAnimalsByLegCountOrdered(legCount, animal.animalClass.className.desc());
            } else {
                animalList = getAnimalsByLegCountOrdered(legCount, animal.animalClass.className.asc());
            }
        } else if (CONTINENT.equalsIgnoreCase(orderBy)) {
            // Continent
            if (DESC.equalsIgnoreCase(direction)) {
                animalList = getAnimalsByLegCountOrdered(legCount, animal.continentName.desc());
            } else {
                animalList = getAnimalsByLegCountOrdered(legCount, animal.continentName.asc());
            }
        } else {
            // Animal Name
            if (DESC.equalsIgnoreCase(direction)) {
                animalList = getAnimalsByLegCountOrdered(legCount, animal.name.desc());
            } else {
                animalList = getAnimalsByLegCountOrdered(legCount, animal.name.asc());
            }
        }

        if (animalList != null & animalList.size() > 0) {
            return animalList;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Animal> getAnimals() {
        return null;
    }

    @Override
    public Map<String, Animal> getMatchingAnimals(List<Animal> animalNames) {
        return null;
    }

    @Override
    public Long getAnimalCount() {
        return null;
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public void testRepo(Model model) {
		
		try {
			QAnimalClass animalClassTable = QAnimalClass.animalClass;
			QAnimal animalTable = QAnimal.animal;
			QContinent continentTable = QContinent.continent;
			
			List<AnimalClass> eurasiaList = (List<AnimalClass>) (Object) getQuerydsl().createQuery()
					.from(animalClassTable)
					.innerJoin(animalTable)
					.on(animalClassTable.className.eq(animalTable.animalClass.className))
					.innerJoin(continentTable)
					.on(animalTable.continentName.eq(continentTable.name))
					.where(
							animalTable.continentName.eq("Asia")
					        .or(animalTable.continentName.eq("Europe"))
						  )
					.fetch();

			for (AnimalClass animalClass : eurasiaList) {
				System.out.println("animalClass: " + animalClass);
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}

    
}

}
