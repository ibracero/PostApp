package com.ibracero.postapp.presentation.ui.detail;

import com.ibracero.postapp.presentation.model.PostDetailViewModel;

interface PostDetailViewInterface {
    void showPostInfo(PostDetailViewModel post);

    void showGetPostInfoFailed(String message);

    void showCommentCounter();
}
