package fr.lgda.safrane;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.mikepenz.iconics.typeface.library.ionicons.Ionicons;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("INFO", "Démarrage de l'application");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout containerBoutons = findViewById(R.id.buttonContainer);
        containerBoutons.setColumnCount(3);

        containerBoutons.addView(new Bouton(this, Ionicons.Icon.values()[16*31 + 0]));
        containerBoutons.addView(new Bouton(this, Ionicons.Icon.values()[2*31 + 17]));
        containerBoutons.addView(new Bouton(this, Ionicons.Icon.values()[17*31 + 26]));
        containerBoutons.addView(new Bouton(this, Ionicons.Icon.values()[12*31 + 25]));

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1);
        layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 2);
        containerBoutons.addView(new BoutonDate(this), layoutParams);
    }
}