package edu.csulb.android.zooapplication;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Charvoz on 19/02/2017.
 */

public class ObjectAdapter extends BaseAdapter {

    private Context context;
    private List<Animal> objects;

    public ObjectAdapter(Context context, List<Animal> objects) {
        Log.d("OBJECTS", objects.toString());
        this.context = context;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Animal getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.my_animal_list, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.animalName);
            holder.image = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Animal currentAnimal = getItem(position);


        holder.text.setText(currentAnimal.getName());

        holder.image.setImageResource(currentAnimal.getDrawableID());


        return convertView;
    }

    class ViewHolder {
        ImageView image;
        TextView text;
    }
}
