package com.ibracero.postapp.presentation.ui.post_list;

import com.ibracero.postapp.presentation.model.PostViewModel;
import com.ibracero.postapp.presentation.ui.base.BaseView;

import java.util.List;

public interface PostListViewInterface extends BaseView {
    void showErrorMessage(String message);

    void showPosts(List<PostViewModel> postViewModels);
}
