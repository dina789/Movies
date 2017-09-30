package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import hk.ust.cse.comp107x.movies.DataModels.MovieDataModel;
import hk.ust.cse.comp107x.movies.R;

/**
 * Created by Dodo on 9/30/2017.
 */

public class MoviesArrayAdapter extends ArrayAdapter <MovieDataModel>{
    public MoviesArrayAdapter(@NonNull Context context, @NonNull MovieDataModel[] objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
MovieDataModel currentMovie=getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movieitem, parent, false);
        }




        ImageView Img = (ImageView ) convertView.findViewById(R.id.imgposter);
        TextView textview = (TextView) convertView.findViewById(R.id.txtTitle);
        // Populate the data into the template view using the data object

        textview.setText(currentMovie.getTitle());
        // Return the completed view to render on screen
        return convertView;
    }
}

