package com.example.kunal.mockitodemo;

import com.example.kunal.mockitodemo.login.Contract;
import com.example.kunal.mockitodemo.login.LoginPresenter;
import com.example.kunal.mockitodemo.login.data.LoginCredentials;
import com.example.kunal.mockitodemo.login.data.LoginRepository;
import com.example.kunal.mockitodemo.login.data.LoginRepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class BasicUnitTest7_presenter {

    private LoginPresenter loginPresenter;

    private LoginCredentials loginCredentials = new LoginCredentials(
            "test@gmail.com",
            "12345");

    @Mock
    private LoginRepositoryImpl loginRepository;

    @Mock
    private Contract.LoginView loginView;

    @Captor
    private ArgumentCaptor<LoginRepository.LoginListener> loginListenerArgumentCaptor;

    @Before
    public void setUpLoginPresenter() {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginRepository, loginView);
    }

    @Test
    public void loginSuccess() {

        loginPresenter.login(loginCredentials);

        verify(loginRepository).login(eq(loginCredentials), loginListenerArgumentCaptor.capture());

        loginListenerArgumentCaptor.getValue().onSuccess();

        verify(loginView).onSuccess();

    }

    @Test
    public void loginFail() {

        loginPresenter.login(loginCredentials);

        verify(loginRepository).login(eq(loginCredentials), loginListenerArgumentCaptor.capture());

        loginListenerArgumentCaptor.getValue().onFailure("Invalid Credentials");

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(loginView).onFailed(argumentCaptor.capture());

        assertEquals("Invalid Credentials", argumentCaptor.getValue());
    }

}
