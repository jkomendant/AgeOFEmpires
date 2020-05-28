package komendant.age.of.empires;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AgeOfEmpiresFactory {

    public AgeOfEmpiresService getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AgeOfEmpiresService service = retrofit.create((AgeOfEmpiresService.class));

        return service;
    }
}
