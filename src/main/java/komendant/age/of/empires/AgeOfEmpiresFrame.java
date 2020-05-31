package komendant.age.of.empires;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AgeOfEmpiresFrame extends JFrame {

    JComboBox<String> selection;
    JComboBox<AgeOfEmpires.Civilizations> civilizationsComboBox;
    JComboBox<AgeOfEmpires.Unit> unitsComboBox;
    JComboBox<AgeOfEmpires.Structure> structureComboBox;
    JComboBox<AgeOfEmpires.Technology> techComboBox;
    JPanel leftPanel;
    JPanel centerPanel;
    JPanel civilizationPanel;
    JPanel unitsPanel;
    JPanel structurePanel;
    JPanel technologyPanel;

    JLabel civilizationNameLabel;
    JLabel civilizationName;
    JLabel civilizationExpansionLabel;
    JLabel civilizationExpansion;
    JLabel armyTypeLabel;
    JLabel armyType;
    JLabel teamBonusLabel;
    JLabel teamBonus;
    JLabel civBonusLabel;
    JTextArea civBonus;
    JLabel unitsNameLabel;
    JLabel unitsName;
    JLabel unitsExpansionLabel;
    JLabel unitsExpansion;
    JLabel unitsAgeLabel;
    JLabel unitsAge;
    JLabel unitsWoodLabel;
    JLabel unitsWood;
    JLabel unitsFoodLabel;
    JLabel unitsFood;
    JLabel unitsStoneLabel;
    JLabel unitsStone;
    JLabel unitsGoldLabel;
    JLabel unitsGold;
    JLabel unitsBuildTimeLabel;
    JLabel unitsBuildTime;
    JLabel unitsReloadTimeLabel;
    JLabel unitsReloadTime;
    JLabel unitsAttackDelayLabel;
    JLabel unitsAttackDelay;
    JLabel unitsMovementRateLabel;
    JLabel unitsMovementRate;
    JLabel unitsLineOfSightLabel;
    JLabel unitsLineOfSight;
    JLabel unitsHitPointsLabel;
    JLabel unitsHitPoints;
    JLabel unitsAttackLabel;
    JLabel unitsAttack;
    JLabel unitsArmorLabel;
    JLabel unitsArmor;
    JLabel structureNameLabel;
    JLabel structureName;
    JLabel structureExpansionLabel;
    JLabel structureExpansion;
    JLabel structureAgeLabel;
    JLabel structureAge;
    JLabel structureWoodLabel;
    JLabel structureWood;
    JLabel structureFoodLabel;
    JLabel structureFood;
    JLabel structureStoneLabel;
    JLabel structureStone;
    JLabel structureGoldLabel;
    JLabel structureGold;
    JLabel structureBuildTimeLabel;
    JLabel structureBuildTime;
    JLabel structureHitPointsLabel;
    JLabel structureHitPoints;
    JLabel structureLineOfSightLabel;
    JLabel structureLineOfSight;
    JLabel structureArmorLabel;
    JLabel structureArmor;

    JLabel techNameLabel;
    JLabel techName;
    JLabel techExpansionLabel;
    JLabel techExpansion;
    JLabel techAgeLabel;
    JLabel techAge;
    JLabel techWoodLabel;
    JLabel techWood;
    JLabel techFoodLabel;
    JLabel techFood;
    JLabel techStoneLabel;
    JLabel techStone;
    JLabel techGoldLabel;
    JLabel techGold;
    JLabel techBuildTimeLabel;
    JLabel techBuildTime;

    AgeOfEmpiresService service;
    AgeOfEmpiresController controller;

    public AgeOfEmpiresFrame(){
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Age of Empires Resources");
        setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        civilizationPanel = new JPanel();
        civilizationPanel.setLayout(new GridLayout(5,2));

        civilizationNameLabel = new JLabel();
        civilizationNameLabel.setText("Civilization Name:");
        civilizationName = new JLabel();

        civilizationExpansionLabel = new JLabel();
        civilizationExpansionLabel.setText("Expansion:");
        civilizationExpansion = new JLabel();
        armyTypeLabel = new JLabel();
        armyTypeLabel.setText("Army Type:");
        armyType = new JLabel();
        teamBonusLabel = new JLabel();
        teamBonusLabel.setText("Team Bonus:");
        teamBonus = new JLabel();
        civBonusLabel = new JLabel();
        civBonusLabel.setText("Civilization Bonus:");
        civBonus = new JTextArea();
        civBonus.setEditable(false);

        civilizationPanel.add(civilizationNameLabel);
        civilizationPanel.add(civilizationName);
        civilizationPanel.add(civilizationExpansionLabel);
        civilizationPanel.add(civilizationExpansion);
        civilizationPanel.add(armyTypeLabel);
        civilizationPanel.add(armyType);
        civilizationPanel.add(teamBonusLabel);
        civilizationPanel.add(teamBonus);
        civilizationPanel.add(civBonusLabel);
        civilizationPanel.add(civBonus);

        unitsPanel = new JPanel();
        unitsPanel.setLayout(new GridLayout(16, 2));

        unitsNameLabel = new JLabel("Unit Name:");
        unitsName  = new JLabel();
        unitsExpansionLabel = new JLabel("Expansion:");
        unitsExpansion = new JLabel();
        unitsAgeLabel = new JLabel("Age:");
        unitsAge = new JLabel();
        unitsWoodLabel = new JLabel("Required Wood:");
        unitsWood = new JLabel();
        unitsFoodLabel = new JLabel("Required Food:");
        unitsFood = new JLabel();
        unitsGoldLabel = new JLabel("Required Gold:");
        unitsGold = new JLabel();
        unitsStoneLabel = new JLabel("Required Stone:");
        unitsStone = new JLabel();
        unitsBuildTimeLabel = new JLabel("Build Time:");
        unitsBuildTime = new JLabel();
        unitsReloadTimeLabel = new JLabel("Reload Time:");
        unitsReloadTime = new JLabel();
        unitsAttackDelayLabel = new JLabel("Attack Delay:");
        unitsAttackDelay = new JLabel();
        unitsMovementRateLabel = new JLabel("Movement Rate:");
        unitsMovementRate = new JLabel();
        unitsLineOfSightLabel = new JLabel("Line of Sight:");
        unitsLineOfSight = new JLabel();
        unitsHitPointsLabel = new JLabel("Hit Points:");
        unitsHitPoints = new JLabel();
        unitsAttackLabel = new JLabel("Attack:");
        unitsAttack = new JLabel();
        unitsArmorLabel = new JLabel("Armor:");
        unitsArmor = new JLabel();

        unitsPanel.add(unitsNameLabel);
        unitsPanel.add(unitsName);
        unitsPanel.add(unitsExpansionLabel);
        unitsPanel.add(unitsExpansion);
        unitsPanel.add(unitsAgeLabel);
        unitsPanel.add(unitsAge);
        unitsPanel.add(unitsWoodLabel);
        unitsPanel.add(unitsWood);
        unitsPanel.add(unitsFoodLabel);
        unitsPanel.add(unitsFood);
        unitsPanel.add(unitsGoldLabel);
        unitsPanel.add(unitsGold);
        unitsPanel.add(unitsStoneLabel);
        unitsPanel.add(unitsStone);
        unitsPanel.add(unitsBuildTimeLabel);
        unitsPanel.add(unitsBuildTime);
        unitsPanel.add(unitsReloadTimeLabel);
        unitsPanel.add(unitsReloadTime);
        unitsPanel.add(unitsAttackDelayLabel);
        unitsPanel.add(unitsAttackDelay);
        unitsPanel.add(unitsMovementRateLabel);
        unitsPanel.add(unitsMovementRate);
        unitsPanel.add(unitsLineOfSightLabel);
        unitsPanel.add(unitsLineOfSight);
        unitsPanel.add(unitsHitPointsLabel);
        unitsPanel.add(unitsHitPoints);
        unitsPanel.add(unitsAttackLabel);
        unitsPanel.add(unitsAttack);
        unitsPanel.add(unitsArmorLabel);
        unitsPanel.add(unitsArmor);

        structurePanel = new JPanel();
        structurePanel.setLayout(new GridLayout(11, 2));

        structureNameLabel = new JLabel("Building Name:");
        structureName = new JLabel();
        structureExpansionLabel = new JLabel("Expansion:");
        structureExpansion = new JLabel();
        structureAgeLabel = new JLabel("Age:");
        structureAge = new JLabel();
        structureWoodLabel = new JLabel("Wood Required:");
        structureWood = new JLabel();
        structureFoodLabel = new JLabel("Food Required:");
        structureFood = new JLabel();
        structureStoneLabel = new JLabel("Stone Required:");
        structureStone = new JLabel();
        structureGoldLabel = new JLabel("Gold Required:");
        structureGold = new JLabel();
        structureBuildTimeLabel = new JLabel("Build Time:");
        structureBuildTime = new JLabel();
        structureHitPointsLabel = new JLabel("Hit Points:");
        structureHitPoints = new JLabel();
        structureLineOfSightLabel = new JLabel("Line of Sight:");
        structureLineOfSight = new JLabel();
        structureArmorLabel = new JLabel("Armor:");
        structureArmor = new JLabel();

        structurePanel.add(structureNameLabel);
        structurePanel.add(structureName);
        structurePanel.add(structureExpansionLabel);
        structurePanel.add(structureExpansion);
        structurePanel.add(structureAgeLabel);
        structurePanel.add(structureAge);
        structurePanel.add(structureWoodLabel);
        structurePanel.add(structureWood);
        structurePanel.add(structureFoodLabel);
        structurePanel.add(structureFood);
        structurePanel.add(structureGoldLabel);
        structurePanel.add(structureGold);
        structurePanel.add(structureStoneLabel);
        structurePanel.add(structureStone);
        structurePanel.add(structureBuildTimeLabel);
        structurePanel.add(structureBuildTime);
        structurePanel.add(structureHitPointsLabel);
        structurePanel.add(structureHitPoints);
        structurePanel.add(structureLineOfSightLabel);
        structurePanel.add(structureLineOfSight);
        structurePanel.add(structureArmorLabel);
        structurePanel.add(structureArmor);

        technologyPanel = new JPanel();
        technologyPanel.setLayout(new GridLayout(8, 2));

        techNameLabel = new JLabel("Technology Name:");
        techName = new JLabel();
        techExpansionLabel = new JLabel("Expansion:");
        techExpansion = new JLabel();
        techAgeLabel = new JLabel("Age:");
        techAge = new JLabel();
        techWoodLabel = new JLabel("Required Wood:");
        techWood = new JLabel();
        techFoodLabel = new JLabel("Required Food:");
        techFood = new JLabel();
        techStoneLabel = new JLabel("Required Stone:");
        techStone = new JLabel();
        techGoldLabel = new JLabel("Required Gold:");
        techGold = new JLabel();
        techBuildTimeLabel = new JLabel("Technology Research Time:");
        techBuildTime = new JLabel();

        technologyPanel.add(techNameLabel);
        technologyPanel.add(techName);
        technologyPanel.add(techExpansionLabel);
        technologyPanel.add(techExpansion);
        technologyPanel.add(techAgeLabel);
        technologyPanel.add(techAge);
        technologyPanel.add(techWoodLabel);
        technologyPanel.add(techWood);
        technologyPanel.add(techFoodLabel);
        technologyPanel.add(techFood);
        technologyPanel.add(techGoldLabel);
        technologyPanel.add(techGold);
        technologyPanel.add(techStoneLabel);
        technologyPanel.add(techStone);
        technologyPanel.add(techBuildTimeLabel);
        technologyPanel.add(techBuildTime);

        selection = new JComboBox<>();
        selection.isEditable();
        selection.addItem("Civilizations");
        selection.addItem("Units");
        selection.addItem("Structures");
        selection.addItem("Technologies");

        civilizationsComboBox = new JComboBox<>();
        civilizationsComboBox.isEditable();
        civilizationsComboBox.isVisible();
        unitsComboBox = new JComboBox<>();
        unitsComboBox.isEditable();
        unitsComboBox.setVisible(false);
        structureComboBox = new JComboBox<>();
        structureComboBox.isEditable();
        structureComboBox.setVisible(false);
        techComboBox = new JComboBox<>();
        techComboBox.isEditable();
        techComboBox.setVisible(false);

        leftPanel.add(selection);

        leftPanel.add(civilizationsComboBox);
        leftPanel.add(unitsComboBox);
        leftPanel.add(structureComboBox);
        leftPanel.add(techComboBox);
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(civilizationPanel);
        centerPanel.add(unitsPanel);
        centerPanel.add(structurePanel);
        centerPanel.add(technologyPanel);

        selection.addActionListener(ActionEvent -> setComboBoxes(selection));

        civilizationsComboBox.addActionListener(ActionEvent -> getCivilizations());
        unitsComboBox.addActionListener(ActionEvent -> getUnits());
        structureComboBox.addActionListener(ActionEvent -> getStructures());
        techComboBox.addActionListener(ActionEvent -> getTech());

        JPanel topPanel = new JPanel();
        add(topPanel, BorderLayout.NORTH);
        JLabel headerMessage = new JLabel("Find out the Resources needed in Age of Empires II!");
        headerMessage.setFont(new Font("Serif", Font.BOLD, 20));
        topPanel.add(headerMessage);

        try{
            service = new AgeOfEmpiresFactory().getInstance();
            controller = new AgeOfEmpiresController(service, civilizationName, civilizationExpansion,
                    armyType, teamBonus, civBonus, unitsName, unitsExpansion, unitsAge, unitsWood, unitsFood,
                    unitsStone, unitsGold, unitsBuildTime, unitsReloadTime, unitsAttackDelay, unitsMovementRate,
                    unitsLineOfSight, unitsHitPoints, unitsAttack, unitsArmor, structureName,
                    structureExpansion, structureAge, structureWood, structureFood, structureStone,
                    structureGold, structureBuildTime, structureHitPoints, structureLineOfSight,
                    structureArmor, techName, techExpansion, techAge, techWood, techFood, techStone, techGold,
                    techBuildTime);
            controller.requestCivilizations(civilizationsComboBox);
            controller.requestUnits(unitsComboBox);
            controller.requestStructures(structureComboBox);
            controller.requestTechnologies(techComboBox);
            unitsPanel.setVisible(false);
            structurePanel.setVisible(false);
            technologyPanel.setVisible(false);


        }
        catch (Exception t){
            t.printStackTrace();
            AgeOfEmpires.NotFoundError message = new AgeOfEmpires.NotFoundError();
            System.out.println(message.message);
        }

    }

    public void setComboBoxes(JComboBox<String> comboBox){
        switch (Objects.requireNonNull(comboBox.getSelectedItem()).toString()){
            case "Civilizations":
                civilizationsComboBox.setVisible(true);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(false);
                civilizationPanel.setVisible(true);
                unitsPanel.setVisible(false);
                structurePanel.setVisible(false);
                technologyPanel.setVisible(false);
                break;
            case "Units":
                civilizationsComboBox.setVisible(false);
                unitsComboBox.setVisible(true);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(false);
                civilizationPanel.setVisible(false);
                unitsPanel.setVisible(true);
                structurePanel.setVisible(false);
                technologyPanel.setVisible(false);
                break;
            case "Structures":
                civilizationsComboBox.setVisible(false);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(true);
                techComboBox.setVisible(false);
                civilizationPanel.setVisible(false);
                unitsPanel.setVisible(false);
                structurePanel.setVisible(true);
                technologyPanel.setVisible(false);
                break;
            case "Technologies":
                civilizationsComboBox.setVisible(false);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(true);
                civilizationPanel.setVisible(false);
                unitsPanel.setVisible(false);
                structurePanel.setVisible(false);
                technologyPanel.setVisible(true);
                break;

        }
    }

    public void getCivilizations(){
        AgeOfEmpires.Civilizations selectCivilization = (AgeOfEmpires.Civilizations) civilizationsComboBox.getSelectedItem();
        assert selectCivilization != null;
        int index = selectCivilization.id -1;
        controller.requestCivilizationsName(index);
    }
    public void getUnits(){
        AgeOfEmpires.Unit selectCivilization = (AgeOfEmpires.Unit) unitsComboBox.getSelectedItem();
        assert selectCivilization != null;
        int index = selectCivilization.id -1;
        controller.requestUnitsName(index);
    }

    public void getStructures(){
        AgeOfEmpires.Structure selectStructure = (AgeOfEmpires.Structure) structureComboBox.getSelectedItem();
        assert selectStructure != null;
        int index = selectStructure.id -1;
        controller.requestStructureName(index);
    }

    public void getTech(){
        AgeOfEmpires.Technology selectTech = (AgeOfEmpires.Technology) techComboBox.getSelectedItem();
        assert selectTech != null;
        int index = selectTech.id -1;
        controller.requestTechName(index);
    }


    public static void main(String[] args) {
        new AgeOfEmpiresFrame().setVisible(true);

    }
}
