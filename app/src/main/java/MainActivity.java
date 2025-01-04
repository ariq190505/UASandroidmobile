package com.example.mytajwid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout menuDrawer;
    private View menuBackdrop;
    private boolean isMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        menuDrawer = findViewById(R.id.menuDrawer);
        menuBackdrop = findViewById(R.id.menuBackdrop);
        ImageView menuIcon = findViewById(R.id.menuIcon);

        TextView item1 = findViewById(R.id.item2);
        TextView item2 = findViewById(R.id.item3);
        TextView item3 = findViewById(R.id.item4);
        TextView item4 = findViewById(R.id.item5);

        TextView menuItem1 = findViewById(R.id.menuItem1);
        TextView menuItem2 = findViewById(R.id.menuItem2);
        TextView menuItem3 = findViewById(R.id.menuItem3);
        TextView menuItem4 = findViewById(R.id.menuItem4);

        // Set click listeners for main menu items
        item1.setOnClickListener(v -> startActivity(new Intent(this, MimnuntasydidActivity.class)));
        item2.setOnClickListener(v -> startActivity(new Intent(this, LamtarifActivity.class)));
        item3.setOnClickListener(v -> startActivity(new Intent(this, QalqalahActivity.class)));
        item4.setOnClickListener(v -> startActivity(new Intent(this, HadhamirActivity.class)));

        // Set click listeners for drawer menu items
        menuItem1.setOnClickListener(v -> {
            startActivity(new Intent(this, MimnuntasydidActivity.class));
            closeMenu();
        });
        menuItem2.setOnClickListener(v -> {
            startActivity(new Intent(this, LamtarifActivity.class));
            closeMenu();
        });
        menuItem3.setOnClickListener(v -> {
            startActivity(new Intent(this, QalqalahActivity.class));
            closeMenu();
        });
        menuItem4.setOnClickListener(v -> {
            startActivity(new Intent(this, HadhamirActivity.class));
            closeMenu();
        });

        // Menu button click listener
        menuIcon.setOnClickListener(v -> toggleMenu());

        // Backdrop click listener to close menu
        menuBackdrop.setOnClickListener(v -> closeMenu());
    }

    private void toggleMenu() {
        if (isMenuOpen) {
            closeMenu();
        } else {
            openMenu();
        }
    }

    private void openMenu() {
        menuDrawer.setVisibility(View.VISIBLE);
        menuBackdrop.setVisibility(View.VISIBLE);
        isMenuOpen = true;
    }

    private void closeMenu() {
        menuDrawer.setVisibility(View.GONE);
        menuBackdrop.setVisibility(View.GONE);
        isMenuOpen = false;
    }

    @Override
    public void onBackPressed() {
        if (isMenuOpen) {
            closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}