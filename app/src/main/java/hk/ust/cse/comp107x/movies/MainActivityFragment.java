package hk.ust.cse.comp107x.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Adapters.MoviesArrayAdapter;
import hk.ust.cse.comp107x.movies.DataModels.MovieDataModel;

public class MainActivityFragment extends Fragment
{
   public  MainActivityFragment(){

   }
MovieDataModel [] MovieDataModels;
    MoviesArrayAdapter MoviesArrayAdapter;
    ListView lstMovies;


    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                         Bundle savedInstanceState)
   {
       View root= inflater.inflate(R.layout.fragment_main , container, false);
       lstMovies=(ListView) root.findViewById(R.id.lstMovies);


// Instantiate the RequestQueue.
       RequestQueue queue = Volley.newRequestQueue(getActivity());
       String url ="https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=b3de77f64d6972c9be859a3d4b56970b";
final Gson gson=new Gson();
// Request a string response from the provided URL.
       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       // Display the first 500 characters of the response string.

                       //Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                       try {
                           JSONObject jsonObject= new JSONObject(response);
                          JSONArray jsonArray= jsonObject.getJSONArray("results");//a5dt array el json w 7wlto to
                           MovieDataModels=gson.fromJson(jsonArray.toString(),MovieDataModel[].class);
                         MoviesArrayAdapter=new MoviesArrayAdapter(getActivity(),MovieDataModels);

                           Toast.makeText(getActivity(),MovieDataModels[0].getOverview(),Toast.LENGTH_SHORT).show();
                       } catch (JSONException e) {
                           e.printStackTrace();
                       }

                   }
               }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(getActivity(),"response", Toast.LENGTH_SHORT).show();
           }
       });
// Add the request to the RequestQueue.
       queue.add(stringRequest);
       return root;



}}
