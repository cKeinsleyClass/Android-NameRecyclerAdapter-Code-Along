package edu.rosehulman.keinslc.namerecycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by keinslc on 12/12/2016.
 */

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mNames;
    private Random mRandom;


    public class ViewHolder extends RecyclerView.ViewHolder{
        // Fields in View Holder
        private TextView nameView;
        private TextView positionView;


        public ViewHolder(View itemView) {
            super(itemView);
            // Capturing views
            nameView = (TextView) itemView.findViewById(R.id.name_view);
            positionView = (TextView) itemView.findViewById(R.id.position_view);
        }
        // TODO ClickListeners
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Same way as in BaseAdapter
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameView.setText(mNames.get(position));
        holder.positionView.setText("I'm #" + position);
    }

    public NameAdapter(Context context) {
        mContext = context;
        mNames = new ArrayList<>();
        mRandom = new Random();
        // Starting with 5 names
        for (int i = 0; i < 5; i++) {
            mNames.add(getRandomName());
        }
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public void addName() {
        mNames.add(getRandomName());
        notifyDataSetChanged();
    }

    public void removeName(int position){
        mNames.remove(position);
        notifyDataSetChanged();
    }

    private String getRandomName() {
        String[] names = new String[]{
                "Hannah", "Emily", "Sarah", "Madison", "Brianna",
                "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
                "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
                "Joseph", "Zachary", "Joshua", "Andrew", "William"
        };
        return names[mRandom.nextInt(names.length)];
    }
}
