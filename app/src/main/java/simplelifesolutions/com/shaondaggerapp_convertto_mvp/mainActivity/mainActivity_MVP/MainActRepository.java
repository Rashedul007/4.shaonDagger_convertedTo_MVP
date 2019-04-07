package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP;

import java.util.List;

import io.reactivex.Observable;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.APIInterface;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;

public class MainActRepository implements Repository {
    public APIInterface retroInterface;

    private List<RandomUsers> results;

    public MainActRepository(APIInterface retroInterface) {
        this.retroInterface = retroInterface;
    }

    @Override
    public Observable<RandomUsers> getResultData() {
        //Observable<RandomUsers> retroCall = retroInterface.getPeople(5);
        Observable<RandomUsers> retroCall = retroInterface.getPeople(5);

        return retroCall;
    }


}
