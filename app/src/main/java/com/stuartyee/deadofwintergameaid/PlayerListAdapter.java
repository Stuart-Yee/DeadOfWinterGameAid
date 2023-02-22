package com.stuartyee.deadofwintergameaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.stuartyee.deadofwintergameaid.models.Player;

import java.util.ArrayList;

public class PlayerListAdapter extends ArrayAdapter <Player> {

    private ArrayList<Player> playerArrayList;
    Context context;

    public PlayerListAdapter(ArrayList<Player> playerData, Context context) {
        super(context, R.layout.player, playerData);
        this.playerArrayList = playerData;
        this.context = context;
    }

    private static class ViewHolder {
        TextView name;
        TextView dice;
        Button minus;
        Button plus;
        Button roll;
        TextView results;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position

        Player player = getItem(position);

        // Check if an existing view is being reused, otherwise inflate this fiew

        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.player,
                    parent,
                    false
            );

            viewHolder.name = (TextView) convertView.findViewById(R.id.playerName);
            viewHolder.dice = (TextView) convertView.findViewById(R.id.playerDice);
            viewHolder.minus = (Button) convertView.findViewById(R.id.btnMinus);
            viewHolder.plus = (Button) convertView.findViewById(R.id.btnPlus);
            viewHolder.roll = (Button) convertView.findViewById(R.id.roll);
            viewHolder.results = (TextView) convertView.findViewById(R.id.results);

            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        // Get the data from the model class
        String dieResults = "";
        if (player.getDieResults() != null) {
            for(Integer i: player.getDieResults()) {
                dieResults += i.toString() + " ";
            }
        }


        viewHolder.name.setText(player.getName());
        viewHolder.dice.setText(player.getDice().toString());
        viewHolder.results.setText(dieResults);

        return convertView;
    }
}
