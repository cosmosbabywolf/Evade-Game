package com.escapegame.administrator.escapegame;

/**
 * Created by Michael on 2016/5/13 0013.
 */
public class rank {
    private int no;
    private String name;
    private int point;
    private String time;

    public rank(int no, String name, int point, String time){
        this.no=no;
        this.name=name;
        this.point=point;
        this.time=time;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPoint() {

        return point;
    }
}
