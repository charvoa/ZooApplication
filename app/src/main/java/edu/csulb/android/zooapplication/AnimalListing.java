package edu.csulb.android.zooapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AnimalListing extends AppCompatActivity {

    List<Animal> animalList = new ArrayList<Animal>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent aboutIntent = new Intent(getBaseContext(), AboutActivity.class);
                startActivity(aboutIntent);
                break;
            case R.id.uninstall:
                Uri packageURI = Uri.parse("package:edu.csulb.android.zooapplication");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(uninstallIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);

        ListView lv = (ListView) findViewById(R.id.animalListView);

        initList();

        lv.setAdapter(new ObjectAdapter(getApplicationContext(), animalList));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                if (position == animalList.size() - 1) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AnimalListing.this);
                    builder1.setMessage("This animal is very scary ! Proceed anyway ?");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent myIntent = new Intent(getBaseContext(), AnimalDetailsActivity.class);

                                    Animal animalSelected = animalList.get(position);

                                    myIntent.putExtra("name", animalSelected.getName());
                                    myIntent.putExtra("resID", animalSelected.getDrawableID());
                                    myIntent.putExtra("description", animalSelected.getDescription());

                                    startActivity(myIntent);
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }  else {
                    Intent myIntent = new Intent(getBaseContext(), AnimalDetailsActivity.class);

                    Animal animalSelected = animalList.get(position);

                    myIntent.putExtra("name", animalSelected.getName());
                    myIntent.putExtra("resID", animalSelected.getDrawableID());
                    myIntent.putExtra("description", animalSelected.getDescription());

                    startActivity(myIntent);
                }
            }
        });

    }

    private void initList() {

        createAnimal("Lion", "lion.jpg", R.drawable.lion, "The lion (Panthera leo) is one of the big cats in the genus Panthera and a member of the family Felidae. The commonly used term African lion collectively denotes the several subspecies in Africa");
        createAnimal("Gorilla", "gorilla.jpg", R.drawable.gorilla,"Gorillas are ground-dwelling, predominantly herbivorous apes that inhabit the forests of central Africa. The eponymous genus Gorilla is dividir into two species: the eastern gorillas and the western gorillas (both critically endangered), and either four or five subspecies. They are the largest living primates");
        createAnimal("Platypus", "orni.jpg", R.drawable.orni, "The platypus (Ornithorhynchus anatinus), sometimes referred to as the duck-billed platypus, is a semiaquatic egg-laying mammal endemic to eastern Australia, including Tasmania");
        createAnimal("Cougar", "puma.jpg", R.drawable.puma, "The cougar (Puma concolor), also commonly known as the mountain lion, puma, panther, or catamount, is a large felid of the subfamily Felinae native to the Americas. Its range, from the Canadian Yukon to the southern Andes of South America, is the greatest of any large wild terrestrial mammal in the Western Hemisphere");
        createAnimal("Snow Leopard", "snowleopard.jpg", R.drawable.snowleopard, "The snow leopard or ounce (Panthera uncia syn. Uncia uncia) is a large cat native to the mountain ranges of Central and South Asia. It is listed as Endangered on the IUCN Red List of Threatened Species because, as of 2003, the size of the global wild population was estimated at 4,080–6,590 adults");

    }

    private void createAnimal(String name, String image, int drawableID, String description) {
        Animal animal = new Animal(name, image,drawableID, description);

        animalList.add(animal);
    }


}


