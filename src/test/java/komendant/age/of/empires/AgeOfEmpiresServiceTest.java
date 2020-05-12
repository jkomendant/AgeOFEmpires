package komendant.age.of.empires;

import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AgeOfEmpiresServiceTest {

    @Test
    public void getCivilizations() throws IOException {
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AgeOfEmpiresService service = retrofit.create(AgeOfEmpiresService.class);

        //when
        AgeOfEmpires civilization = service.getCivilizations().execute().body();

        //then
        assertNotNull(civilization);
        List<AgeOfEmpires.Civilizations> civil = civilization.civilizations;
        assertNotNull(civil);
        AgeOfEmpires.Civilizations civilization1 = civil.get(0);
        assertNotNull(civilization1);
        //assertNotNull(civilization1.id);
        assertNotNull(civilization1.name);
        assertNotNull(civilization1.armyType);
        assertNotNull(civilization1.expansion);
        assertNotNull(civilization1.civBonus);
        assertNotNull(civilization1.uniqueTech);
        assertNotNull(civilization1.teamBonus);
        assertNotNull(civilization1.uniqueUnit);
    }

    @Test
    public void getUnits() throws IOException {
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AgeOfEmpiresService service = retrofit.create(AgeOfEmpiresService.class);

        //when
        AgeOfEmpires units = service.getUnits().execute().body();

        //then
        assertNotNull(units);
        List<AgeOfEmpires.Unit> unitList = units.units;
        assertNotNull(unitList);
        AgeOfEmpires.Unit unit = unitList.get(0);
        assertNotNull(unit);
        //assertNotNull(unit.id);
        assertNotNull(unit.age);
        assertNotNull(unit.name);
        assertNotNull(unit.armor);
        //assertNotNull(unit.attack);
        assertNotNull(unit.createdIn);
        assertNotNull(unit.expansion);
        //assertNotNull(unit.attackDelay);
        //assertNotNull(unit.buildTime);
        assertNotNull(unit.cost);
        //assertNotNull(unit.hitPoints);
        //assertNotNull(unit.lineOfSight);
        //assertNotNull(unit.movementRate);
        //assertNotNull(unit.reload_time);


    }

    @Test
    public void getStructures() throws IOException {
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AgeOfEmpiresService service = retrofit.create(AgeOfEmpiresService.class);

        //when
        AgeOfEmpires structures = service.getStructures().execute().body();

        //then
        assertNotNull(structures);
        List<AgeOfEmpires.Structure> structureList = structures.structures;
        assertNotNull(structureList);
        AgeOfEmpires.Structure structure = structureList.get(0);
        assertNotNull(structure);
        //assertNotNull(structure.id);
        assertNotNull(structure.age);
        assertNotNull(structure.armor);
        assertNotNull(structure.expansion);
        assertNotNull(structure.name);
        //assertNotNull(structure.buildTime);
        assertNotNull(structure.cost);
        //assertNotNull(structure.hitPoints);
        //assertNotNull(structure.lineOfSight);

    }

    @Test
    public void getTechnologies() throws IOException {
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AgeOfEmpiresService service = retrofit.create(AgeOfEmpiresService.class);

        //when
        AgeOfEmpires technologies = service.getTechnologies().execute().body();

        //then

        assertNotNull(technologies);
        List<AgeOfEmpires.Technology> technologyList = technologies.technologies;
        assertNotNull(technologyList);
        AgeOfEmpires.Technology technology = technologyList.get(0);
        assertNotNull(technology);
        //assertNotNull(technology.id);
        assertNotNull(technology.age);
        assertNotNull(technology.developsIn);
        assertNotNull(technology.expansion);
        assertNotNull(technology.name);
        //assertNotNull(technology.buildTime);
        assertNotNull(technology.cost);
    }
}