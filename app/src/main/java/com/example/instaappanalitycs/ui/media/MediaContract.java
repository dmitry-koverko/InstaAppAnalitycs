package com.example.instaappanalitycs.ui.media;

public interface MediaContract {

    interface View {

    }

    interface Presenter {

        void getListFromRealm();
        void getData(int after);
        void close();
        void setTypeSort(TypeSortMedia type);

    }

}
