package simplelifesolutions.com.shaondaggerapp_convertto_mvp.http;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;

public interface APIInterface {

    @GET("api")
    Observable<RandomUsers> getPeople(@Query("results") int size) ;

    @GET("api")
    Observable<RandomUsers> getGenderWise(@Query("gender") String strFormat, @Query("results") int size);
}

