package komendant.age.of.empires;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class ageOfEmpires {

    HashMap<String, List<civilizations>> civilization;

    class civilizations{
        int id;
        String name;
        String expansion;
        @SerializedName("army_type")
        String armyType;
        @SerializedName("unique_unit")
        String[] uniqueUnit;
        @SerializedName("unique_tech")
        String[] uniqueTech;
        @SerializedName("team_bonus")
        String[] teamBonus;
        @SerializedName("civilization_bonus")
        String[] civBonus;

    }

    class Unit{
        int id;
        String name;
        String expansion;
        String age;
        @SerializedName("created_in")
        String createdIn;
        Cost[] cost;
        @SerializedName("build_time")
        int buildTime;
        @SerializedName("reload_time")
        double reload_time;
        @SerializedName("attack_delay")
        double attackDelay;
        @SerializedName("movement_rate")
        double movementRate;
        @SerializedName("line_of_sight")
        int lineOfSight;
        @SerializedName("hit_points")
        int hitPoints;
        int attack;
        String armor;
    }

    class Structure{
        int id;
        String name;
        String expansion;
        String age;
        Cost[] cost;
        @SerializedName("build_time")
        int buildTime;
        @SerializedName("hit_points")
        int hitPoints;
        @SerializedName("line_of_sight")
        int lineOfSight;
        String armor;
    }

    class Technology{
        int id;
        String name;
        String expansion;
        String age;
        @SerializedName("develops_in")
        String developsIn;
        Cost[] cost;
        @SerializedName("build_time")
        int buildTime;
    }

    class NotFoundError{
        String message;
    }

    class Cost{
        int wood;
        int food;
        int stone;
        int gold;
    }
}
