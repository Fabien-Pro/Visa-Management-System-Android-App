package com.example.visamanagementsystem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ApplicantBaseAdapter extends BaseAdapter {

    Context context;
    String listFruit[];
    int ListImage[];
    LayoutInflater inflater;
    private ViewGroup root;

    public ApplicantBaseAdapter(Context ctx, String [] fruitList, int [] images){

        this.context = ctx;
        this.listFruit = fruitList;
        this.ListImage = images;
        inflater = LayoutInflater.from(ctx);

    }


    @Override
    public int getCount() {
        return listFruit.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_applicant_list_view2, null);
        TextView txtView = (TextView) view.findViewById(R.id.textView);
        ImageView fruitImg = (ImageView) view.findViewById(R.id.imageIcon);
        txtView.setText(listFruit[i]);
        fruitImg.setImageResource(ListImage[i]);

        return view;
    }
}
