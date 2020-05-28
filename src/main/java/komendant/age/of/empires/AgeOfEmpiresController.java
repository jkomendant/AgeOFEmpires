package komendant.age.of.empires;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.util.Arrays;
import java.util.List;

public class AgeOfEmpiresController implements Callback<AgeOfEmpires> {

    private AgeOfEmpiresService service;
    JTextArea civilizationTextArea;
    JLabel unitsLabel;
    JLabel structureLabel;
    JLabel technologyLabel;
    BasicArrowButton nextButton;
    BasicArrowButton previousButton;

    public  AgeOfEmpiresController(AgeOfEmpiresService service,
                                   JTextArea civilizationLabel,
                                   JLabel unitsLabel,
                                   JLabel structureLabel,
                                   JLabel technologyLabel,
                                   BasicArrowButton nextButton,
                                   BasicArrowButton previousButton){

        this.service = service;
        this.civilizationTextArea = civilizationLabel;
        this.unitsLabel = unitsLabel;
        this.structureLabel = structureLabel;
        this.technologyLabel = technologyLabel;
        this.nextButton = nextButton;
        this.previousButton = previousButton;

    }

    public void requestCivilizations(JComboBox<AgeOfEmpires.Civilizations> civilizationsComboBox){
        service.getCivilizations().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires civilizations = response.body();
                assert civilizations != null;
                List<AgeOfEmpires.Civilizations> civilization = civilizations.civilizations;
                for(AgeOfEmpires.Civilizations civilization1 : civilization){
                    civilizationsComboBox.addItem(civilization1);
                }


            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });

    }

    public void requestUnits(JComboBox<AgeOfEmpires.Unit> unitsComboBox){
        service.getUnits().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires units = response.body();
                assert units != null;

                List<AgeOfEmpires.Unit> unitList = units.units;
                for(AgeOfEmpires.Unit unit : unitList){
                    unitsComboBox.addItem(unit);
                }
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

    public void requestStructures(JComboBox<AgeOfEmpires.Structure> structureComboBox){

        service.getStructures().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                assert response.body() != null;
                AgeOfEmpires structure = response.body();
                List<AgeOfEmpires.Structure> structureList = structure.structures;
                for(AgeOfEmpires.Structure unit : structureList){
                    structureComboBox.addItem(unit);
                }
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

    public void requestTechnologies(JComboBox<AgeOfEmpires.Technology> techComboBox){

        service.getTechnologies().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                assert response.body() != null;
                AgeOfEmpires technologies = response.body();

                List<AgeOfEmpires.Technology> technologyList = technologies.technologies;
                for(AgeOfEmpires.Technology tech : technologyList){
                    techComboBox.addItem(tech);
                }
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {

    }

    @Override
    public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
        t.printStackTrace();
    }

    public void requestCivilizationsName(int index) {
        service.getCivilizations().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires civilizations = response.body();
                assert civilizations != null;

                List<AgeOfEmpires.Civilizations> civilization = civilizations.civilizations;
                AgeOfEmpires.Civilizations civilization1 = civilization.get(index);

                civilizationTextArea.setText(civilization1.name + "\n" + civilization1.expansion + "\n"
                        + civilization1.armyType + "\n"
                        + civilization1.teamBonus + "\n"
                        + Arrays.toString(civilization1.civBonus));

            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });
    }
    public void requestUnitsName(int index){
        service.getUnits().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires units = response.body();
                assert units != null;

                List<AgeOfEmpires.Unit> unitList = units.units;
                AgeOfEmpires.Unit unit = unitList.get(index);

                civilizationTextArea.setText(unit.name + "\n" + unit.expansion + "\n"
                        + unit.age + "\n"
                        + unit.cost.food +  "\n"
                        + unit.cost.wood + "\n" + unit.cost.gold
                        + "\n" + unit.buildTime + "\n" + unit.reload_time + "\n" + unit.attackDelay
                        + "\n" + unit.movementRate + "\n" + unit.lineOfSight + "\n" + unit.hitPoints
                        + "\n" + unit.attack + "\n" + unit.armor);
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

    public void requestStructureName(int index) {
        service.getStructures().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires structures = response.body();
                assert structures != null;

                List<AgeOfEmpires.Structure> structureList = structures.structures;
                AgeOfEmpires.Structure structure = structureList.get(index);

                civilizationTextArea.setText(structure.name + "\n" + structure.expansion + "\n"
                        + structure.age + "\n"
                        + structure.cost.wood + "\n" + structure.cost.food + "\n"
                        + structure.cost.gold + "\n" + structure.cost.stone + "\n"
                        + structure.buildTime + "\n" + structure.hitPoints + "\n"
                        + structure.lineOfSight + "\n" + structure.armor + "\n");

            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });
    }

    public void requestTechName(int index) {
        service.getTechnologies().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires technologies = response.body();
                assert technologies != null;

                List<AgeOfEmpires.Technology> technologyList = technologies.technologies;
                AgeOfEmpires.Technology technology = technologyList.get(index);

                civilizationTextArea.setText(technology.name + "\n" + technology.expansion + "\n"
                        + technology.age + "\n"
                        + technology.cost.food + "\n" + technology.cost.wood + "\n"
                        + technology.cost.stone + "\n" + technology.cost.gold + "\n"
                        + technology.buildTime);

            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });
    }
}
