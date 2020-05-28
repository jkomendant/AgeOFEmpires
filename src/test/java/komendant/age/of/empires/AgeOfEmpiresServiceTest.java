package komendant.age.of.empires;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AgeOfEmpiresServiceTest {

    @Test
    public void getCivilizations() throws IOException {
        //given
        AgeOfEmpiresService service = new AgeOfEmpiresFactory().getInstance();

        //when
        AgeOfEmpires civilization = service.getCivilizations().execute().body();

        //then
        assertNotNull(civilization);
        List<AgeOfEmpires.Civilizations> civil = civilization.civilizations;
        assertNotNull(civil);
        AgeOfEmpires.Civilizations civilization1 = civil.get(0);
        assertNotNull(civilization1);
        assert(civilization1.id > 0);
        assertNotNull(civilization1.name);
        assertNotNull(civilization1.armyType);
        assertNotNull(civilization1.expansion);
        assertNotNull(civilization1.civBonus);
        assertNotNull(civilization1.teamBonus);
    }

    @Test
    public void getUnits() throws IOException {
        //given
        AgeOfEmpiresService service = new AgeOfEmpiresFactory().getInstance();

        //when
        AgeOfEmpires units = service.getUnits().execute().body();

        //then
        assertNotNull(units);
        List<AgeOfEmpires.Unit> unitList = units.units;
        assertNotNull(unitList);
        AgeOfEmpires.Unit unit = unitList.get(0);
        assertNotNull(unit);
        assert(unit.id > 0);
        assertNotNull(unit.age);
        assertNotNull(unit.name);
        assertNotNull(unit.armor);
        assert(unit.attack > 0);
        assertNotNull(unit.expansion);
        assert(unit.attackDelay > 0);
        assert(unit.buildTime > 0);
        assertNotNull(unit.cost);
        assert(unit.cost.food == 0);
        assert(unit.cost.wood == 25);
        assert(unit.cost.stone == 0);
        assert(unit.cost.gold == 45);
        assert(unit.hitPoints > 0);
        assert(unit.lineOfSight > 0);
        assert(unit.movementRate > 0);
        assert(unit.reload_time > 0);


    }

    @Test
    public void getStructures() throws IOException {
        //given
        AgeOfEmpiresService service = new AgeOfEmpiresFactory().getInstance();

        //when
        AgeOfEmpires structures = service.getStructures().execute().body();

        //then
        assertNotNull(structures);
        List<AgeOfEmpires.Structure> structureList = structures.structures;
        assertNotNull(structureList);
        AgeOfEmpires.Structure structure = structureList.get(0);
        assertNotNull(structure);
        assert(structure.id > 0);
        assertNotNull(structure.age);
        assertNotNull(structure.armor);
        assertNotNull(structure.expansion);
        assertNotNull(structure.name);
        assert(structure.buildTime > 0);
        assertNotNull(structure.cost);
        assert(structure.cost.food >= 0);
        assert(structure.cost.wood >= 0);
        assert(structure.cost.stone >= 0);
        assert(structure.cost.gold >= 0);

        assert(structure.hitPoints > 0);
        assert(structure.lineOfSight > 0);

    }

    @Test
    public void getTechnologies() throws IOException {
        //given
        AgeOfEmpiresService service = new AgeOfEmpiresFactory().getInstance();

        //when
        AgeOfEmpires technologies = service.getTechnologies().execute().body();

        //then

        assertNotNull(technologies);
        List<AgeOfEmpires.Technology> technologyList = technologies.technologies;
        assertNotNull(technologyList);
        AgeOfEmpires.Technology technology = technologyList.get(0);
        assertNotNull(technology);
        assert(technology.id > 0);
        assertNotNull(technology.age);
        assertNotNull(technology.expansion);
        assertNotNull(technology.name);
        assert(technology.buildTime > 0);
        assertNotNull(technology.cost);
        assert(technology.cost.food >= 0);
        assert(technology.cost.wood >= 0);
        assert(technology.cost.stone >= 0);
        assert(technology.cost.gold >= 0);

    }
}