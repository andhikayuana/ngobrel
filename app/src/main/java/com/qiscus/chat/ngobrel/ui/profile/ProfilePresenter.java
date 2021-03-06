package com.qiscus.chat.ngobrel.ui.profile;

import com.qiscus.chat.ngobrel.data.model.User;
import com.qiscus.chat.ngobrel.data.repository.UserRepository;

/**
 * Created on : May 16, 2018
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
public class ProfilePresenter {
    private View view;
    private UserRepository userRepository;

    public ProfilePresenter(View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
    }

    public void loadUser() {
        userRepository.getCurrentUser(
                view::showUser,
                throwable -> {
                });
    }

    public void logout() {
        userRepository.logout();
        view.showLoginPage();
    }

    public interface View {
        void showUser(User user);

        void showLoginPage();
    }
}
