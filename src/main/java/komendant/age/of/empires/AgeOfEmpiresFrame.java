package komendant.age.of.empires;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AgeOfEmpiresFrame extends JFrame {

    private String[] listing = {"Aztecs", "Britons", "Bizantines", "Celts", "Chinese", "Franks", "Goths",
                                "Huns", "Japanese", "Koreans", "Mayans", "Mongols", "Persians", "Saracens",
                                "Spanish", "Teutons", "Turks", "Vikings"};
    private String[] type = {"Units", "Structures", "Technologies"};

    public AgeOfEmpiresFrame(){
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Age of Empires Resources");
        setLayout(new BorderLayout());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AgeOfEmpiresService service = retrofit.create(AgeOfEmpiresService.class);

        AgeOfEmpiresController controller = new AgeOfEmpiresController(service);
        controller.requestData();
        List<AgeOfEmpires.Civilizations> civilization =  new AgeOfEmpires().civilizations;
        List<AgeOfEmpires.Structure> structures = new AgeOfEmpires().structures;
        List<AgeOfEmpires.Technology> technologies = new AgeOfEmpires().technologies;
        List<AgeOfEmpires.Unit> units = new AgeOfEmpires().units;

        JLabel civilizationLabel = new JLabel("Civilization:");
        JComboBox civils = new JComboBox(listing);
        JLabel typesLabel = new JLabel("Type:");
        JComboBox types = new JComboBox(type);
        JButton enter = new JButton("Enter");
        JPanel topPanel = new JPanel();
        add(topPanel, BorderLayout.NORTH);
        JLabel headerMessage = new JLabel("Find out the Resources needed in Age of Empires II!");
        topPanel.add(headerMessage);
        JPanel leftPanel = new JPanel();
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setLayout(new GridLayout(3,2));
        leftPanel.add(civilizationLabel);
        leftPanel.add(civils);
        leftPanel.add(typesLabel);
        leftPanel.add(types);
        leftPanel.add(enter);
        JPanel mainArea = new JPanel();
        add(mainArea, BorderLayout.CENTER);
        JTextArea output = new JTextArea();
        mainArea.add(output);

        //enter.addActionListener(actionEvent -> );

    }

    public static void main(String[] args) {
        new AgeOfEmpiresFrame().setVisible(true);

    }
}


