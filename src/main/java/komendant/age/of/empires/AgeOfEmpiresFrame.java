package komendant.age.of.empires;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.util.Objects;

public class AgeOfEmpiresFrame extends JFrame {

    JComboBox<String> selection;
    JComboBox<AgeOfEmpires.Civilizations> civilsComboBox;
    JComboBox<AgeOfEmpires.Unit> unitsComboBox;
    JComboBox<AgeOfEmpires.Structure> structureComboBox;
    JComboBox<AgeOfEmpires.Technology> techComboBox;
    JPanel leftPanel;
    JPanel centerPanel;
    JTextArea civilizationLabel;
    JLabel unitsLabel;
    JLabel structureLabel;
    JLabel technologyLabel;
    BasicArrowButton nextButton;
    BasicArrowButton previousButton;
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

        civilizationLabel = new JTextArea();
        unitsLabel = new JLabel();
        structureLabel = new JLabel();
        technologyLabel = new JLabel();
        nextButton = new BasicArrowButton(BasicArrowButton.EAST);
        previousButton = new BasicArrowButton(BasicArrowButton.WEST);

        selection = new JComboBox<>();
        selection.isEditable();
        selection.addItem("Civilizations");
        selection.addItem("Units");
        selection.addItem("Structures");
        selection.addItem("Technologies");

        civilsComboBox = new JComboBox<>();
        civilsComboBox.isEditable();
        civilsComboBox.isVisible();
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

        leftPanel.add(civilsComboBox);
        leftPanel.add(unitsComboBox);
        leftPanel.add(structureComboBox);
        leftPanel.add(techComboBox);
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(civilizationLabel);

        selection.addActionListener(ActionEvent -> setComboBoxes(selection));

        civilsComboBox.addActionListener(ActionEvent -> getCivilizations());
        unitsComboBox.addActionListener(ActionEvent -> getUnits());
        structureComboBox.addActionListener(ActionEvent -> getStructures());
        techComboBox.addActionListener(ActionEvent -> getTech());

        JPanel topPanel = new JPanel();
        add(topPanel, BorderLayout.NORTH);
        JLabel headerMessage = new JLabel("Find out the Resources needed in Age of Empires II!");
        topPanel.add(headerMessage);

        try{
            service = new AgeOfEmpiresFactory().getInstance();
            controller = new AgeOfEmpiresController(service, civilizationLabel, unitsLabel,
                    structureLabel, technologyLabel, nextButton, previousButton);
            controller.requestCivilizations(civilsComboBox);
            controller.requestUnits(unitsComboBox);
            controller.requestStructures(structureComboBox);
            controller.requestTechnologies(techComboBox);

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
                civilsComboBox.setVisible(true);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(false);
                civilizationLabel.setText("");
                break;
            case "Units":
                civilsComboBox.setVisible(false);
                unitsComboBox.setVisible(true);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(false);
                civilizationLabel.setText("");
                break;
            case "Structures":
                civilsComboBox.setVisible(false);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(true);
                techComboBox.setVisible(false);
                civilizationLabel.setText("");
                break;
            case "Technologies":
                civilsComboBox.setVisible(false);
                unitsComboBox.setVisible(false);
                structureComboBox.setVisible(false);
                techComboBox.setVisible(true);
                civilizationLabel.setText("");
                break;

        }
    }

    public void getCivilizations(){
        AgeOfEmpires.Civilizations selectCivilization = (AgeOfEmpires.Civilizations) civilsComboBox.getSelectedItem();
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
