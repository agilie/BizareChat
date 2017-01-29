package com.internship.pbt.bizarechat.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheSharedPreferences {

    private static volatile CacheSharedPreferences INSTANCE;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String FILE_NAME = "CurrenAccount";

    private CacheSharedPreferences(Context context){
        mSharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static CacheSharedPreferences getInstance(Context context){
        CacheSharedPreferences local = INSTANCE;
        if(local == null) {
            synchronized (CacheSharedPreferences.class) {
                local = INSTANCE;
                if(local == null){
                    INSTANCE = local = new CacheSharedPreferences(context);
                }
            }
        }
        return local;
    }

    public void putToken(String value){
        mEditor.putString(CacheConstants.CURRENT_ACCOUNT_TOKEN, value);
        mEditor.apply();
    }

    public String getToken(){
        return mSharedPreferences.getString(CacheConstants.CURRENT_ACCOUNT_TOKEN, null);
    }

    public void putAccountAvatarBlobId(Long value){
        mEditor.putLong(CacheConstants.CURRENT_ACCOUNT_AVATAR, value);
        mEditor.apply();
    }

    public Long getAccountAvatarBlobId(){
        return mSharedPreferences.getLong(CacheConstants.CURRENT_ACCOUNT_AVATAR, -1);
    }

    public void putIsUserAuthorized(boolean status){
        mEditor.putBoolean(CacheConstants.CURRENT_ACCOUNT_AUTHORIZATION, status);
        mEditor.apply();
    }

    public boolean isAuthorized(){
        return mSharedPreferences.getBoolean(CacheConstants.CURRENT_ACCOUNT_AUTHORIZATION, false);
    }

    public void putCurrentPassword(String password){
        mEditor.putString(CacheConstants.CURRENT_ACCOUNT_PASSWORD, password);
        mEditor.apply();
    }

    public String getCurrentPassword(){
        return mSharedPreferences.getString(CacheConstants.CURRENT_ACCOUNT_PASSWORD, null);
    }

    public void putCurrentEmail(String email){
        mEditor.putString(CacheConstants.CURRENT_ACCOUNT_EMAIL, email);
        mEditor.apply();
    }

    public String getCurrentEmail(){
        return mSharedPreferences.getString(CacheConstants.CURRENT_ACCOUNT_EMAIL, null);
    }

    public void putCurrentFacebookId(Long id){
        mEditor.putLong(CacheConstants.CURRENT_ACCOUNT_FACEBOOK_ID, id);
        mEditor.apply();
    }

    public Long getCurrentFacebookId(){
        return mSharedPreferences.getLong(CacheConstants.CURRENT_ACCOUNT_FACEBOOK_ID, -1);
    }


}
