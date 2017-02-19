package com.rcmapps.strictmockito;

/**
 * Created by receme on 2/19/17.
 */

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void configure(){

        if(view.isInternetAvaialble()){
            view.performLogin();
            view.showMainView();
        }
        else{
            view.showError();
            view.closeApplication();
        }
    }
}
