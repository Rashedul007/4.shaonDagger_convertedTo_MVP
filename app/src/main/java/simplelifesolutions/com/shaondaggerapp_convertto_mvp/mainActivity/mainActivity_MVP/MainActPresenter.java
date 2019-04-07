package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;

public class MainActPresenter implements  MainActMVP.Presenter{

    private MainActMVP.View view;
    private MainActMVP.Model model;

    private Disposable subscription = null;

    public MainActPresenter(MainActMVP.Model model) {
        this.model = model;
    }


    @Override
    public void setView(MainActMVP.View vw) {
        this.view = vw;
    }

    @Override
    public void loadData() {
        subscription =  model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<RandomUsers>() {
                    @Override
                    public void onNext(RandomUsers randomUsers) {
                        if(view != null)
                            view.updateData(randomUsers);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(view != null)
                            view.showSnackBar("Error while retriving data from retrofit.");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void unSubscribeRx() {
        if(subscription != null)
            if(!subscription.isDisposed())
                subscription.dispose();
    }
}
