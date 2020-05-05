package komendant.age.of.empires;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ageOfEmpiresService {

    @GET("/civilizations\n")
    Call<ageOfEmpires> getCivilizations();

    @GET("/units\n")
    Call<ageOfEmpires> getUnits();

    @GET("/structures\n")
    Call<ageOfEmpires> getStructures();

    @GET("/technologies\n")
    Call<ageOfEmpires> getTechnologies();




}
