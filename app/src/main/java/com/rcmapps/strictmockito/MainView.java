package com.rcmapps.strictmockito;

/**
 * Created by receme on 2/19/17.
 */

public interface MainView {
    boolean isInternetAvaialble();
    void performLogin();
    void showMainView();
    void showError();
    void closeApplication();
}
