package komendant.age.of.empires;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class AgeOfEmpiresController implements Callback<AgeOfEmpires> {

    private AgeOfEmpiresService service;
    JLabel civilizationName;
    JLabel civilizationExpansion;
    JLabel armyType;
    JLabel teamBonus;
    JTextArea civBonus;
    JLabel unitsName;
    JLabel unitsExpansion;
    JLabel unitsAge;
    JLabel unitsWood;
    JLabel unitsFood;
    JLabel unitsStone;
    JLabel unitsGold;
    JLabel unitsBuildTime;
    JLabel unitsReloadTime;
    JLabel unitsAttackDelay;
    JLabel unitsMovementRate;
    JLabel unitsLineOfSight;
    JLabel unitsHitPoints;
    JLabel unitsAttack;
    JLabel unitsArmor;
    JLabel structureName;
    JLabel structureExpansion;
    JLabel structureAge;
    JLabel structureWood;
    JLabel structureFood;
    JLabel structureStone;
    JLabel structureGold;
    JLabel structureBuildTime;
    JLabel structureHitPoints;
    JLabel structureLineOfSight;
    JLabel structureArmor;
    JLabel techName;
    JLabel techExpansion;
    JLabel techAge;
    JLabel techWood;
    JLabel techFood;
    JLabel techStone;
    JLabel techGold;
    JLabel techBuildTime;

    public AgeOfEmpiresController(AgeOfEmpiresService service,
                                  JLabel civilizationName,
                                  JLabel civilizationExpansion,
                                  JLabel armyType,
                                  JLabel teamBonus,
                                  JTextArea civBonus,
                                  JLabel unitsName,
                                  JLabel unitsExpansion,
                                  JLabel unitsAge,
                                  JLabel unitsWood,
                                  JLabel unitsFood,
                                  JLabel unitsStone,
                                  JLabel unitsGold,
                                  JLabel unitsBuildTime,
                                  JLabel unitsReloadTime,
                                  JLabel unitsAttackDelay,
                                  JLabel unitsMovementRate,
                                  JLabel unitsLineOfSight,
                                  JLabel unitsHitPoints,
                                  JLabel unitsAttack,
                                  JLabel unitsArmor,
                                  JLabel structureName,
                                  JLabel structureExpansion,
                                  JLabel structureAge,
                                  JLabel structureWood,
                                  JLabel structureFood,
                                  JLabel structureStone,
                                  JLabel structureGold,
                                  JLabel structureBuildTime,
                                  JLabel structureHitPoints,
                                  JLabel structureLineOfSight,
                                  JLabel structureArmor,
                                  JLabel techName,
                                  JLabel techExpansion,
                                  JLabel techAge,
                                  JLabel techWood,
                                  JLabel techFood,
                                  JLabel techStone,
                                  JLabel techGold,
                                  JLabel techBuildTime) {

        this.service = service;
        this.civilizationName = civilizationName;
        this.civilizationExpansion = civilizationExpansion;
        this.armyType = armyType;
        this.teamBonus = teamBonus;
        this.civBonus = civBonus;

        this.unitsName = unitsName;
        this.unitsExpansion = unitsExpansion;
        this.unitsAge = unitsAge;
        this.unitsWood = unitsWood;
        this.unitsFood = unitsFood;
        this.unitsStone = unitsStone;
        this.unitsGold = unitsGold;
        this.unitsBuildTime = unitsBuildTime;
        this.unitsReloadTime = unitsReloadTime;
        this.unitsAttackDelay = unitsAttackDelay;
        this.unitsMovementRate = unitsMovementRate;
        this.unitsLineOfSight = unitsLineOfSight;
        this.unitsHitPoints = unitsHitPoints;
        this.unitsAttack = unitsAttack;
        this.unitsArmor = unitsArmor;

        this.structureName = structureName;
        this.structureExpansion = structureExpansion;
        this.structureAge = structureAge;
        this.structureWood = structureWood;
        this.structureFood = structureFood;
        this.structureStone = structureStone;
        this.structureGold = structureGold;
        this.structureBuildTime = structureBuildTime;
        this.structureHitPoints = structureHitPoints;
        this.structureLineOfSight = structureLineOfSight;
        this.structureArmor = structureArmor;

        this.techName = techName;
        this.techExpansion = techExpansion;
        this.techAge = techAge;
        this.techWood = techWood;
        this.techFood = techFood;
        this.techStone = techStone;
        this.techGold = techGold;
        this.techBuildTime = techBuildTime;

    }

    public void requestCivilizations(JComboBox<AgeOfEmpires.Civilizations> civilizationsComboBox) {
        service.getCivilizations().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires civilizations = response.body();
                assert civilizations != null;
                List<AgeOfEmpires.Civilizations> civilization = civilizations.civilizations;
                for (AgeOfEmpires.Civilizations civilization1 : civilization) {
                    civilizationsComboBox.addItem(civilization1);
                }


            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });

    }

    public void requestUnits(JComboBox<AgeOfEmpires.Unit> unitsComboBox) {
        service.getUnits().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires units = response.body();
                assert units != null;

                List<AgeOfEmpires.Unit> unitList = units.units;
                for (AgeOfEmpires.Unit unit : unitList) {
                    unitsComboBox.addItem(unit);
                }
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

    public void requestStructures(JComboBox<AgeOfEmpires.Structure> structureComboBox) {

        service.getStructures().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                assert response.body() != null;
                AgeOfEmpires structure = response.body();
                List<AgeOfEmpires.Structure> structureList = structure.structures;
                for (AgeOfEmpires.Structure unit : structureList) {
                    structureComboBox.addItem(unit);
                }
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

    public void requestTechnologies(JComboBox<AgeOfEmpires.Technology> techComboBox) {

        service.getTechnologies().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                assert response.body() != null;
                AgeOfEmpires technologies = response.body();

                List<AgeOfEmpires.Technology> technologyList = technologies.technologies;
                for (AgeOfEmpires.Technology tech : technologyList) {
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

                civilizationName.setText(civilization1.name);
                civilizationExpansion.setText(civilization1.expansion);
                armyType.setText(civilization1.armyType);
                teamBonus.setText(civilization1.teamBonus);
                civBonus.setText(Arrays.toString(civilization1.civBonus));
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });
    }

    public void requestUnitsName(int index) {
        service.getUnits().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires units = response.body();
                assert units != null;

                List<AgeOfEmpires.Unit> unitList = units.units;
                AgeOfEmpires.Unit unit = unitList.get(index);

                unitsName.setText(unit.name);
                unitsExpansion.setText(unit.expansion);
                unitsAge.setText(unit.age);
                unitsWood.setText(String.valueOf(unit.cost.wood));
                unitsFood.setText(String.valueOf(unit.cost.food));
                unitsStone.setText(String.valueOf(unit.cost.stone));
                unitsGold.setText(String.valueOf(unit.cost.gold));
                unitsBuildTime.setText(String.valueOf(unit.buildTime));
                unitsReloadTime.setText(String.valueOf(unit.reload_time));
                unitsAttackDelay.setText(String.valueOf(unit.attackDelay));
                unitsMovementRate.setText(String.valueOf(unit.movementRate));
                unitsLineOfSight.setText(String.valueOf(unit.lineOfSight));
                unitsHitPoints.setText(String.valueOf(unit.hitPoints));
                unitsAttack.setText(String.valueOf(unit.attack));
                unitsArmor.setText(unit.armor);
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

                structureName.setText(structure.name);
                structureExpansion.setText(structure.expansion);
                structureAge.setText(structure.age);
                structureWood.setText(String.valueOf(structure.cost.wood));
                structureFood.setText(String.valueOf(structure.cost.food));
                structureGold.setText(String.valueOf(structure.cost.gold));
                structureStone.setText(String.valueOf(structure.cost.stone));
                structureBuildTime.setText(String.valueOf(structure.buildTime));
                structureHitPoints.setText(String.valueOf(structure.hitPoints));
                structureLineOfSight.setText(String.valueOf(structure.lineOfSight));
                structureArmor.setText(structure.armor);

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

                techName.setText(technology.name);
                techExpansion.setText(technology.expansion);
                techAge.setText(technology.age);
                techWood.setText(String.valueOf(technology.cost.wood));
                techFood.setText(String.valueOf(technology.cost.food));
                techStone.setText(String.valueOf(technology.cost.stone));
                techGold.setText(String.valueOf(technology.cost.gold));
                techBuildTime.setText(String.valueOf(technology.buildTime));
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });
    }
}
