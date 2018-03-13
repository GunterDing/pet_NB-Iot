package com.example.hdx.pettool_nb_iot;

/*
 * Created by hdx on 2018/3/8.
 */

public class petItemInfo {
    private String strPetName;  //名字
    private String strStatus;  //宠物状态
    private int iHealthIndex;  //健康指数
    private int iPetImg;
    private boolean bSex;    //性别 0:雌 1:雄

    public petItemInfo(){}

    public petItemInfo(String strPetName, boolean bSex, int iPetImg){
        this.strPetName = strPetName;
        this.bSex = bSex;
        this.iPetImg = iPetImg;
    }

    public String getPetName(){
        return strPetName;
    }

    public String getStatus(){
        return strStatus;
    }

    public int getHealthIndex(){
        return iHealthIndex;
    }

    public boolean getSex(){
        return bSex;
    }

    public int getPetImg(){
        return iPetImg;
    }

    public void setPetImg(int iPetImg){
        this.iPetImg = iPetImg;
    }

    public void setPetName(String strPetName){
        this.strPetName = strPetName;
    }

    public void setStatus(String strStatus){
        this.strStatus = strStatus;
    }

    public void setHealthIndex(int iHealthIndex){
        this.iHealthIndex = iHealthIndex;
    }

    public void setSex(boolean bSex){
        this.bSex = bSex;
    }
}
