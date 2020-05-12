package komendant.age.of.empires;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AgeOfEmpiresService {

    @GET("/api/v1/civilizations")
    Call<AgeOfEmpires> getCivilizations();

    @GET("/api/v1/units")
    Call<AgeOfEmpires> getUnits();

    @GET("/api/v1/structures")
    Call<AgeOfEmpires> getStructures();

    @GET("/api/v1/technologies")
    Call<AgeOfEmpires> getTechnologies();




}
