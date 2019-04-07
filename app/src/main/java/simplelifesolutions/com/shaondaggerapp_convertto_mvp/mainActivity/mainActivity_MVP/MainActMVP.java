package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP;

import io.reactivex.Observable;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;

public interface MainActMVP {

    interface View{
                void updateData(RandomUsers mRandomUSer);
                void showSnackBar(String strSnakbarMsg);
        }

    interface Presenter{
                void setView(MainActMVP.View vw);
                void loadData();
                void unSubscribeRx();


        }

    interface Model{
        Observable<RandomUsers> result();
    }
}
