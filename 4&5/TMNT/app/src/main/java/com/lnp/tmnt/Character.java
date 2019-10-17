package com.lnp.tmnt;

import java.util.UUID;

public class Character {
    private UUID mId;
    private int mCharacterPicId;
    private String mName;
    private String mNickName;
    private int mProgramPicId;
    private String mProgramName;
    private int mProgram;


    public Character() {

    }

    public Character(UUID id, int cpid, String name, String nname, int ppid, String pname) {
        mId = id;
        mCharacterPicId = cpid;
        mName = name;
        mNickName = nname;
        mProgramPicId = ppid;
        mProgramName = pname;
        mProgram = R.raw.tmnt_theme;
    }
    public Character(UUID id, int cpid, String name, String nname, int ppid, String pname, int pid) {
        mId = id;
        mCharacterPicId = cpid;
        mName = name;
        mNickName = nname;
        mProgramPicId = ppid;
        mProgramName = pname;
        mProgram = pid;
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public int getmCharacterPicId() {
        return mCharacterPicId;
    }

    public void setmCharacterPicId(int mCharacterPicId) {
        this.mCharacterPicId = mCharacterPicId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNickName() {
        return mNickName;
    }

    public void setmNickName(String mNickName) {
        this.mNickName = mNickName;
    }

    public int getmProgramPicId() {
        return mProgramPicId;
    }

    public void setmProgramPicId(int mProgramPicId) {
        this.mProgramPicId = mProgramPicId;
    }

    public String getmProgramName() {
        return mProgramName;
    }

    public void setmProgramName(String mProgramName) {
        this.mProgramName = mProgramName;
    }

    public int getmProgram() {
        return mProgram;
    }
}
