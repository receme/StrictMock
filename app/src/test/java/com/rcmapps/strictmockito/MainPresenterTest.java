package com.rcmapps.strictmockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by receme on 2/19/17.
 */
public class MainPresenterTest {

    private MainView mockView;
    private MainPresenter presenter;
    @Before
    public void setUp() throws Exception {
        mockView = MockUtils.strictMock(MainView.class);
        presenter = new MainPresenter(mockView);
    }

    @Test
    public void configure() throws Exception {

        Mockito.when(mockView.isInternetAvaialble()).thenReturn(true);
        Mockito.doNothing().when(mockView).performLogin();
        Mockito.doNothing().when(mockView).showMainView();

        MockUtils.verifyNoUnstubbedInteractions(mockView);

        presenter.configure();

        Mockito.verify(mockView,Mockito.times(1)).performLogin();
        Mockito.verify(mockView,Mockito.times(1)).showMainView();

    }

}