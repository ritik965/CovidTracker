package com.example.covidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountryModel> {

    private Context context;
    private List<CountryModel>countryModels;

    private List<CountryModel>countryModels1;
    public CustomAdapter( Context context, List<CountryModel>countryModels) {
        super(context, R.layout.list,countryModels);
        this.context=context;
        this.countryModels=countryModels;
        this.countryModels1=countryModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,null,true);
        TextView t=view.findViewById(R.id.country_name);
        ImageView i=view.findViewById(R.id.image_flag);

        t.setText(countryModels1.get(position).getCountry());
        Glide.with(context).load(countryModels1.get(position).getFlag()).into(i);
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return  countryModels1.size();
    }

    @Nullable
    @Override
    public CountryModel getItem(int position) {
        return countryModels1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = countryModels.size();
                    filterResults.values = countryModels;

                }else{
                    List<CountryModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(CountryModel itemsModel:countryModels){
                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countryModels1 = (List<CountryModel>) results.values;
                Countries.countryModels = (List<CountryModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
