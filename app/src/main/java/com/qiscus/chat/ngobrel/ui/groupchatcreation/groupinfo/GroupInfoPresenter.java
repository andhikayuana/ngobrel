package com.qiscus.chat.ngobrel.ui.groupchatcreation.groupinfo;

import com.qiscus.chat.ngobrel.data.model.User;
import com.qiscus.chat.ngobrel.data.repository.ChatRoomRepository;
import com.qiscus.sdk.data.model.QiscusChatRoom;
import com.qiscus.sdk.util.QiscusErrorLogger;

import java.util.List;

/**
 * Created on : May 17, 2018
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
public class GroupInfoPresenter {
    private View view;
    private ChatRoomRepository chatRoomRepository;

    public GroupInfoPresenter(View view, ChatRoomRepository chatRoomRepository) {
        this.view = view;
        this.chatRoomRepository = chatRoomRepository;
    }

    public void createGroup(String name, List<User> members) {
        view.showLoading();
        chatRoomRepository.createGroupChatRoom(name, members,
                qiscusChatRoom -> {
                    view.dismissLoading();
                    view.showGroupChatRoomPage(qiscusChatRoom);
                },
                throwable -> {
                    view.dismissLoading();
                    view.showErrorMessage(QiscusErrorLogger.getMessage(throwable));
                }
        );
    }

    public interface View {
        void showLoading();

        void dismissLoading();

        void showGroupChatRoomPage(QiscusChatRoom chatRoom);

        void showErrorMessage(String errorMessage);
    }
}
