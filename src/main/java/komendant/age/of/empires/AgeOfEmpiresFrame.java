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
    JPanel civilizationImagePanel;
    JPanel unitsImagePanel;
    JPanel structureImagePanel;
    JPanel techImagePanel;

    JLabel civilizationImage;
    JLabel civilizationName;
    JLabel civilizationExpansionLabel;
    JLabel civilizationExpansion;
    JLabel armyTypeLabel;
    JLabel armyType;
    JLabel uniqueUnitLabel;
    JLabel uniqueUnit;
    JLabel uniqueTechLabel;
    JLabel uniqueTech;
    JLabel teamBonusLabel;
    JLabel teamBonus;
    JLabel civBonusLabel;
    JTextArea civBonus;

    JLabel unitsImage;
    JLabel unitsName;
    JLabel unitsExpansionLabel;
    JLabel unitsExpansion;
    JLabel unitsAgeLabel;
    JLabel unitsAge;
    JLabel unitsCreatedInLabel;
    JLabel unitsCreatedIn;
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

    JLabel structureImage;
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

    JLabel techImage;
    JLabel techName;
    JLabel techExpansionLabel;
    JLabel techExpansion;
    JLabel techAgeLabel;
    JLabel techAge;
    JLabel techDevelopsInLabel;
    JLabel techDevelopsIn;
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
        setSize(800, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Age of Empires Resources");
        setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        civilizationPanel = new JPanel();
        civilizationPanel.setLayout(new GridLayout(6,2));
        civilizationImagePanel = new JPanel();
        civilizationImagePanel.setLayout(new GridLayout(1, 2));

        civilizationImage = new JLabel();
        civilizationName = new JLabel();
        civilizationName.setFont(new Font("Serif", Font.BOLD, 20));
        civilizationExpansionLabel = new JLabel();
        civilizationExpansionLabel.setText("Expansion of Game:");
        civilizationExpansion = new JLabel();
        armyTypeLabel = new JLabel();
        armyTypeLabel.setText("Army Type:");
        armyType = new JLabel();
        uniqueUnitLabel = new JLabel("Unique Unit:");
        uniqueUnit = new JLabel();
        uniqueTechLabel = new JLabel("Unique Technology:");
        uniqueTech = new JLabel();
        teamBonusLabel = new JLabel();
        teamBonusLabel.setText("Team Bonus:");
        teamBonus = new JLabel();
        civBonusLabel = new JLabel();
        civBonusLabel.setText("Civilization Bonus:");
        civBonus = new JTextArea();
        civBonus.setEditable(false);
        civBonus.setLineWrap(true);
        civBonus.setWrapStyleWord(true);

        civilizationImagePanel.add(civilizationName);
        civilizationImagePanel.add(civilizationImage);
        civilizationPanel.add(civilizationExpansionLabel);
        civilizationPanel.add(civilizationExpansion);
        civilizationPanel.add(armyTypeLabel);
        civilizationPanel.add(armyType);
        civilizationPanel.add(uniqueUnitLabel);
        civilizationPanel.add(uniqueUnit);
        civilizationPanel.add(uniqueTechLabel);
        civilizationPanel.add(uniqueTech);
        civilizationPanel.add(teamBonusLabel);
        civilizationPanel.add(teamBonus);
        civilizationPanel.add(civBonusLabel);
        civilizationPanel.add(civBonus);

        unitsPanel = new JPanel();
        unitsPanel.setLayout(new GridLayout(14, 2));
        unitsImagePanel = new JPanel();
        unitsImagePanel.setLayout(new GridLayout(1, 2));

        unitsName  = new JLabel();
        unitsName.setFont(new Font("Serif", Font.BOLD, 20));
        unitsImage = new JLabel();
        unitsExpansionLabel = new JLabel("Expansion of Game:");
        unitsExpansion = new JLabel();
        unitsAgeLabel = new JLabel("Age:");
        unitsAge = new JLabel();
        unitsCreatedInLabel = new JLabel("Created In:");
        unitsCreatedIn = new JLabel();
        unitsWoodLabel = new JLabel("Required Wood:");
        unitsWood = new JLabel();
        unitsFoodLabel = new JLabel("Required Food:");
        unitsFood = new JLabel();
        unitsGoldLabel = new JLabel("Required Gold:");
        unitsGold = new JLabel();
        unitsStoneLabel = new JLabel("Required Stone:");
        unitsStone = new JLabel();
        unitsBuildTimeLabel = new JLabel("Build Time (in seconds):");
        unitsBuildTime = new JLabel();
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

        unitsImagePanel.add(unitsName);
        unitsImagePanel.add(unitsImage);
        unitsPanel.add(unitsExpansionLabel);
        unitsPanel.add(unitsExpansion);
        unitsPanel.add(unitsAgeLabel);
        unitsPanel.add(unitsAge);
        unitsPanel.add(unitsCreatedInLabel);
        unitsPanel.add(unitsCreatedIn);
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
        structurePanel.setLayout(new GridLayout(10, 2));
        structureImagePanel = new JPanel();
        structureImagePanel.setLayout(new GridLayout(1, 2));

        structureImage = new JLabel();
        structureName = new JLabel();
        structureName.setFont(new Font("Serif", Font.BOLD, 20));
        structureExpansionLabel = new JLabel("Expansion of Game:");
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

        structureImagePanel.add(structureName);
        structureImagePanel.add(structureImage);
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
        techImagePanel = new JPanel();
        techImagePanel.setLayout(new GridLayout(1, 2));

        techImage = new JLabel();
        techName = new JLabel();
        techName.setFont(new Font("Serif", Font.BOLD, 20));
        techExpansionLabel = new JLabel("Expansion of Game:");
        techExpansion = new JLabel();
        techAgeLabel = new JLabel("Age:");
        techAge = new JLabel();
        techDevelopsInLabel = new JLabel("Develops In:");
        techDevelopsIn = new JLabel();
        techWoodLabel = new JLabel("Required Wood:");
        techWood = new JLabel();
        techFoodLabel = new JLabel("Required Food:");
        techFood = new JLabel();
        techStoneLabel = new JLabel("Required Stone:");
        techStone = new JLabel();
        techGoldLabel = new JLabel("Required Gold:");
        techGold = new JLabel();
        techBuildTimeLabel = new JLabel("Technology Research Time (in seconds):");
        techBuildTime = new JLabel();

        techImagePanel.add(techName);
        techImagePanel.add(techImage);
        technologyPanel.add(techExpansionLabel);
        technologyPanel.add(techExpansion);
        technologyPanel.add(techAgeLabel);
        technologyPanel.add(techAge);
        technologyPanel.add(techDevelopsInLabel);
        technologyPanel.add(techDevelopsIn);
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

        centerPanel.add(civilizationImagePanel);
        centerPanel.add(civilizationPanel);
        centerPanel.add(unitsImagePanel);
        centerPanel.add(unitsPanel);
        centerPanel.add(structureImagePanel);
        centerPanel.add(structurePanel);
        centerPanel.add(techImagePanel);
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
            controller = new AgeOfEmpiresController(service, civilizationName, civilizationImage,
                    civilizationExpansion, armyType, uniqueUnit, uniqueTech, teamBonus, civBonus, unitsImage, unitsName, unitsExpansion,
                    unitsAge, unitsCreatedIn, unitsWood, unitsFood, unitsStone, unitsGold, unitsBuildTime, unitsMovementRate,
                    unitsLineOfSight, unitsHitPoints, unitsAttack,
                    unitsArmor, structureImage, structureName, structureExpansion, structureAge, structureWood, structureFood,
                    structureStone, structureGold, structureBuildTime, structureHitPoints, structureLineOfSight,
                    structureArmor, techImage, techName, techExpansion, techAge, techDevelopsIn, techWood, techFood, techStone,
                    techGold, techBuildTime);
            controller.requestCivilizations(civilizationsComboBox);
            controller.requestUnits(unitsComboBox);
            controller.requestStructures(structureComboBox);
            controller.requestTechnologies(techComboBox);
            unitsPanel.setVisible(false);
            unitsImagePanel.setVisible(false);
            structurePanel.setVisible(false);
            structureImagePanel.setVisible(false);
            technologyPanel.setVisible(false);
            techImagePanel.setVisible(false);
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
                civilizationImagePanel.setVisible(true);
                civilizationPanel.setVisible(true);
                unitsPanel.setVisible(false);
                unitsImagePanel.setVisible(false);
                structurePanel.setVisible(false);
                structureImagePanel.setVisible(false);
                techImagePanel.setVisible(false);
                technologyPanel.setVisible(false);
                break;
            case "Units":
                civilizationsComboBox.setVisible(false);
                unitsComboBox.setVisible(true);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(false);
                civilizationImagePanel.setVisible(false);
                civilizationPanel.setVisible(false);
                unitsPanel.setVisible(true);
                unitsImagePanel.setVisible(true);
                structurePanel.setVisible(false);
                structureImagePanel.setVisible(false);
                techImagePanel.setVisible(false);
                technologyPanel.setVisible(false);
                break;
            case "Structures":
                civilizationsComboBox.setVisible(false);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(true);
                techComboBox.setVisible(false);
                civilizationImagePanel.setVisible(false);
                civilizationPanel.setVisible(false);
                unitsPanel.setVisible(false);
                unitsImagePanel.setVisible(false);
                structureImagePanel.setVisible(true);
                structurePanel.setVisible(true);
                techImagePanel.setVisible(false);
                technologyPanel.setVisible(false);
                break;
            case "Technologies":
                civilizationsComboBox.setVisible(false);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(true);
                civilizationImagePanel.setVisible(false);
                civilizationPanel.setVisible(false);
                unitsPanel.setVisible(false);
                unitsImagePanel.setVisible(false);
                structurePanel.setVisible(false);
                structureImagePanel.setVisible(false);
                techImagePanel.setVisible(true);
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