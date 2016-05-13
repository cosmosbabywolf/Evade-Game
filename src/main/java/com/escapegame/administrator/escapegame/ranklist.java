package com.escapegame.administrator.escapegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class ranklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
    }
    public ranklist(String text){
        this.generateRank();
    }
    private ArrayList<rank> ranks =new ArrayList<>();
    public void generateRank(){
        ranks.add(new rank(1,"Michael",100,"2mins"));
    }
    public ArrayList getList(){
        return ranks;
    }
}
