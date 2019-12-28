package com.wayfinder.wayfinder;

/**
 * Created by anupamchugh on 26/12/15.
 */
public enum ModelObject {

    RED(R.string.red, R.layout.custom_speaker_layout),
    BLUE(R.string.blue, R.layout.custom_speaker_layout),
    GREEN(R.string.green, R.layout.custom_speaker_layout);




    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
