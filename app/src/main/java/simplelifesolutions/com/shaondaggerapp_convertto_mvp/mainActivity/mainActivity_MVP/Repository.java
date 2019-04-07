package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP;

import io.reactivex.Observable;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;

public interface Repository {
    Observable<RandomUsers> getResultData();

}
