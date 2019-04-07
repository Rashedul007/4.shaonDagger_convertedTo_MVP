package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import simplelifesolutions.com.shaondaggerapp_convertto_mvp.R;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.APIInterface;

import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.apiModels.RandomUsers;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP.MainActMVP;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.root.MainApp;

public class MainActivity extends AppCompatActivity implements MainActMVP.View
 {

    private RecyclerView mRecyclerView;
    final String LOG_TAG = "testLogTag";

   @Inject
   public MyRecyclerAdapter mRecyclerAdapter;

   @Inject
   public APIInterface retroInterface;

   @Inject
   MainActMVP.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MainActivityComponent mDaggerMainActComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .applicationComponent(MainApp.getAppInstance(this).getAPIserviceComponents())
                .build()    ;


        mDaggerMainActComponent.injectMainActivity(this);

        initViews();
    }


    private void initViews()
    {
        mRecyclerView = findViewById(R.id.myRecyclerView);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
        Log.d("Log_msg" , "::inside onStart::");
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unSubscribeRx();
    }


    @Override
    public void updateData(RandomUsers mRandomUSer) {
        Log.d("Log_msg" , "::inside onUpdate:: size-" + mRandomUSer.getResults().size());
        mRecyclerAdapter.setItems(mRandomUSer.getResults());


    }

    @Override
    public void showSnackBar(String strSnakbarMsg) {
        Toast.makeText(this, ""+ strSnakbarMsg.toString(), Toast.LENGTH_SHORT).show();
    }

}
