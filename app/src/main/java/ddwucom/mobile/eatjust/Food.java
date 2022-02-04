package ddwucom.mobile.eatjust;

import java.io.Serializable;

public class Food implements Serializable {
    private long _id;
//    private byte bPhoto;
    private String date;
    private int bCalorie;
    private int bCarbohydrate;
    private int bProtein;
    private int bFat;
    //    private byte lPhoto;
    private int lCalorie;
    private int lCarbohydrate;
    private int lProtein;
    private int lFat;
    //    private byte dPhoto;
    private int dCalorie;
    private int dCarbohydrate;
    private int dProtein;
    private int dFat;

    public Food(String date, int bCalorie, int bCarbohydrate, int bProtein, int bFat, int lCalorie, int lCarbohydrate, int lProtein, int lFat, int dCalorie, int dCarbohydrate,  int dProtein, int dFat) {
        this.date = date;
        this.bCalorie = bCalorie;
        this.bCarbohydrate = bCarbohydrate;
        this.bProtein = bProtein;
        this.bFat = bFat;
        this.lCalorie = lCalorie;
        this.lCarbohydrate = lCarbohydrate;
        this.lProtein = lProtein;
        this.lFat = lFat;
        this.dCalorie = dCalorie;
        this.dCarbohydrate = dCarbohydrate;
        this.dProtein = dProtein;
        this.dFat = dFat;
    }

    public Food(long _id, String date, int bCalorie, int bCarbohydrate, int bProtein, int bFat, int lCalorie, int lCarbohydrate, int lProtein, int lFat, int dCalorie, int dCarbohydrate,  int dProtein, int dFat) {
        this._id = _id;
        this.date = date;
        this.bCalorie = bCalorie;
        this.bCarbohydrate = bCarbohydrate;
        this.bProtein = bProtein;
        this.bFat = bFat;
        this.lCalorie = lCalorie;
        this.lCarbohydrate = lCarbohydrate;
        this.lProtein = lProtein;
        this.lFat = lFat;
        this.dCalorie = dCalorie;
        this.dCarbohydrate = dCarbohydrate;
        this.dProtein = dProtein;
        this.dFat = dFat;
    }

    public long get_id() {
        return _id;
    }
    public void set_id(long _id) {
        this._id = _id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getbCalorie() {
        return bCalorie;
    }
    public void setbCalorie(int bCalorie) {
        this.bCalorie = bCalorie;
    }
    public int getbFat() {
        return bFat;
    }
    public void setbFat(int bFat) {
        this.bFat = bFat;
    }
    public int getbProtein() {
        return bProtein;
    }
    public void setbProtein(int bProtein) {
        this.bProtein = bProtein;
    }
    public int getbCarbohydrate() {
        return bCarbohydrate;
    }
    public void setbCarbohydrate(int bCarbohydrate) {
        this.bCarbohydrate = bCarbohydrate;
    }
    public int getlCalorie() {
        return lCalorie;
    }
    public void setlCalorie(int lCalorie) {
        this.lCalorie = lCalorie;
    }
    public int getlFat() {
        return lFat;
    }
    public void setlFat(int lFat) {
        this.lFat = lFat;
    }
    public int getlProtein() {
        return lProtein;
    }
    public void setlProtein(int lProtein) {
        this.lProtein = lProtein;
    }
    public int getlCarbohydrate() {
        return lCarbohydrate;
    }
    public void setlCarbohydrate(int lCarbohydrate) {
        this.lCarbohydrate = lCarbohydrate;
    }
    public int getdCalorie() {
        return dCalorie;
    }
    public void setdCalorie(int dCalorie) {
        this.dCalorie = dCalorie;
    }
    public int getdFat() {
        return dFat;
    }
    public void setdFat(int dFat) {
        this.dFat = dFat;
    }
    public int getdProtein() {
        return dProtein;
    }
    public void setdProtein(int dProtein) {
        this.dProtein = dProtein;
    }
    public int getdCarbohydrate() {
        return dCarbohydrate;
    }
    public void setdCarbohydrate(int dCarbohydrate) {
        this.dCarbohydrate = dCarbohydrate;
    }
}
