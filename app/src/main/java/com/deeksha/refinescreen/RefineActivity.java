package com.deeksha.refinescreen;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;


public class RefineActivity extends AppCompatActivity {
    private CheckBox checkHyperlocal, checkJobs, checkSearchResults, checkOnSale, checkNewArrivals, checkFreeShipping;
    private RadioGroup radioGroupSort;
    private SeekBar seekBarPrice;
    private RatingBar ratingBar;
    private Button buttonApplyFilters, buttonResetFilters;

    private Map<String, Object> filters = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);

        checkHyperlocal = findViewById(R.id.checkHyperlocal);
        checkJobs = findViewById(R.id.checkJobs);
        checkSearchResults = findViewById(R.id.checkSearchResults);
        radioGroupSort = findViewById(R.id.radioGroupSort);
        seekBarPrice = findViewById(R.id.seekBarPrice);
        ratingBar = findViewById(R.id.ratingBar);
        checkOnSale = findViewById(R.id.checkOnSale);
        checkNewArrivals = findViewById(R.id.checkNewArrivals);
        checkFreeShipping = findViewById(R.id.checkFreeShipping);
        buttonApplyFilters = findViewById(R.id.buttonApplyFilters);
        buttonResetFilters = findViewById(R.id.buttonResetFilters);

        buttonApplyFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyFilters();
                Toast.makeText(RefineActivity.this, "Filters Applied", Toast.LENGTH_SHORT).show();
                // Send filters to the search or explorer activity
                // Intent intent = new Intent(RefineActivity.this, SearchResultActivity.class);
                // intent.putExtra("filters", filters);
                // startActivity(intent);
            }
        });

        buttonResetFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFilters();
                Toast.makeText(RefineActivity.this, "Filters Reset", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void applyFilters() {
        filters.clear();

        filters.put("Hyperlocal", checkHyperlocal.isChecked());
        filters.put("Jobs", checkJobs.isChecked());
        filters.put("SearchResults", checkSearchResults.isChecked());
        filters.put("OnSale", checkOnSale.isChecked());
        filters.put("NewArrivals", checkNewArrivals.isChecked());
        filters.put("FreeShipping", checkFreeShipping.isChecked());

        // Handle sorting options
        int selectedSortId = radioGroupSort.getCheckedRadioButtonId();
        RadioButton selectedSort = findViewById(selectedSortId);
        if (selectedSort != null) {
            filters.put("SortBy", selectedSort.getText().toString());
        }

        // Handle price range
        int priceRange = seekBarPrice.getProgress();
        filters.put("PriceRange", priceRange);

        // Handle ratings
        float rating = ratingBar.getRating();
        filters.put("Rating", rating);

        // You can use these filters in your search or explorer activity
    }

    private void resetFilters() {
        checkHyperlocal.setChecked(false);
        checkJobs.setChecked(false);
        checkSearchResults.setChecked(false);
        checkOnSale.setChecked(false);
        checkNewArrivals.setChecked(false);
        checkFreeShipping.setChecked(false);
        radioGroupSort.clearCheck();
        seekBarPrice.setProgress(0);
        ratingBar.setRating(0);
    }
}

