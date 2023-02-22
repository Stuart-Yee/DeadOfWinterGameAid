package com.stuartyee.deadofwintergameaid;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stuartyee.deadofwintergameaid.models.Player;
import com.stuartyee.deadofwintergameaid.utilities.DiceRoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView playersListView;
    private static PlayerListAdapter playerListAdapter;
    ArrayList<Player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a listView
        playersListView = findViewById(R.id.listview);

        // 2- Data source
        playerList = new ArrayList<>();
        playerList.add(new Player("Player 1"));
        playerList.add(new Player("Player 2"));
        playerList.add(new Player("Player 3"));

        // 3- Adapter
        playerListAdapter = new PlayerListAdapter(playerList, getApplicationContext());
        playersListView.setAdapter(playerListAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.exposure: String outcome = rollExposure();
                Toast.makeText(this, outcome, Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

//    public void subtractClick(View view){
//        Button button = (Button) view;
//        String tag = button.getTag().toString();
//        String operation = "subtract";
//        switch (tag) {
//            case "p1": changeDice(player1Dice, operation);
//            break;
//            case "p2": changeDice(player2Dice, operation);
//            default:
//                return;
//        }
//    }
//
//    public void addClick(View view){
//        Button button = (Button) view;
//        String tag = button.getTag().toString();
//        String operation = "add";
//        switch (tag) {
//            case "p1": changeDice(player1Dice, operation);
//                break;
//            case "p2": changeDice(player2Dice, operation);
//            default:
//                return;
//        }
//    }
//
//    public void changeDice(TextView text, String operation) {
//        Integer dice = parseInt(text.getText().toString());
//        if (operation == "subtract" && dice >= 1) {
//            dice--;
//        } else if (operation == "add") {
//            dice++;
//        }
//        text.setText(dice.toString());
//    }
//
//    public int[] rollDice(View view) {
//        Button button = (Button) view;
//        String tag = button.getTag().toString();
//        TextView text;
//        TextView resultsText;
//        switch (tag) {
//            case "p1": text = player1Dice; resultsText = p1Results;
//            break;
//            case "p2": text = player2Dice; resultsText = p2Results;
//            break;
//            default: text = null; resultsText = null;
//        }
//        Integer dice = parseInt(text.getText().toString());
//        int[] results = DiceRoller.rollDice(dice);
////        for (int i=0; i < dice; i++) {
////            Random rand = new Random();
////            int die = rand.nextInt(6);
////            results[i] = die+1;
////        }
//        Arrays.sort(results);
//        String resultsStr = "";
//        for (Integer die : results) {
//            resultsStr += die.toString() +" ";
//        }
//        resultsText.setText(resultsStr);
//
//        return results;
//    }

    public String rollExposure() {
        Random rand = new Random();
        String outcome = "Blank, no effect";
        int result = rand.nextInt(12);
        if (result == 0) {
            outcome = "BITTEN!";
        } else if (result < 3) {
            outcome = "Frost Bite!";
        } else if (result < 6) {
            outcome = "Wounded";
        }
        return outcome;
    }

}