package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP;

import io.reactivex.Observable;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;

public class MainActModel implements MainActMVP.Model {

    Repository repository;

    public MainActModel(Repository repository) { this.repository = repository;    }


    @Override
    public Observable<RandomUsers> result() {
        return    repository.getResultData();

    }
}
