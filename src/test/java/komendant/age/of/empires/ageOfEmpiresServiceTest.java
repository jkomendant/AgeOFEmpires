package komendant.age.of.empires;

import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ageOfEmpiresServiceTest {

    @Test
    public void getCivilizations() throws IOException {
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ageOfEmpiresService service = retrofit.create(ageOfEmpiresService.class);

        //when
        ageOfEmpires civilization = service.getCivilizations().execute().body();

        //then
        assertNotNull(civilization);
        HashMap<String, List<ageOfEmpires.civilizations>> civil = civilization.civilization;
        assertFalse(civil.isEmpty());
        ageOfEmpires.civilizations civilization1 = civil.get("civilizations").get(0);
        assertNotNull(civilization1);
        assertNotNull(civilization1.id);
        assertNotNull(civilization1.name);
        assertNotNull(civilization1.armyType);
        assertNotNull(civilization1.expansion);
        assertNotNull(civilization1.civBonus);
        assertNotNull(civilization1.uniqueTech);
        assertNotNull(civilization1.teamBonus);
        assertNotNull(civilization1.uniqueUnit);
    }
}