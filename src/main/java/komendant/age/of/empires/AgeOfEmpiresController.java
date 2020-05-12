package komendant.age.of.empires;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgeOfEmpiresController {

    private AgeOfEmpiresService service;

    public  AgeOfEmpiresController(AgeOfEmpiresService service){
        this.service = service;
    }

    public void requestData(){
        service.getCivilizations().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires.Civilizations civilizations = response.body().civilizations.get(0);
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {
                t.getStackTrace();

            }
        });
        service.getUnits().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires.Unit units = response.body().units.get(0);
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
        service.getStructures().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires.Structure structure = response.body().structures.get(0);
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
        service.getTechnologies().enqueue(new Callback<AgeOfEmpires>() {
            @Override
            public void onResponse(Call<AgeOfEmpires> call, Response<AgeOfEmpires> response) {
                AgeOfEmpires.Technology technology = response.body().technologies.get(0);
            }

            @Override
            public void onFailure(Call<AgeOfEmpires> call, Throwable t) {

            }
        });
    }

}
