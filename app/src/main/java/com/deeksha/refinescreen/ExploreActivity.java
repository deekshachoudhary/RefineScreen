package com.deeksha.refinescreen;



import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    private EditText searchBar;
    private Spinner sortSpinner;
    private LinearLayout featuredItemsContainer;
    private LinearLayout popularItemsContainer;
    private LinearLayout recommendedItemsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        searchBar = findViewById(R.id.searchBar);
        sortSpinner = findViewById(R.id.sortSpinner);
        featuredItemsContainer = findViewById(R.id.featuredItemsContainer);
        popularItemsContainer = findViewById(R.id.popularItemsContainer);
        recommendedItemsContainer = findViewById(R.id.recommendedItemsContainer);

        // Initialize sort options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sort_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(adapter);

        // Load dynamic content
        loadFeaturedItems();
        loadPopularItems();
        loadRecommendedItems();
    }

    private void loadFeaturedItems() {
        // Placeholder for featured items - Update with actual data
        List<Integer> featuredImages = new ArrayList<>();
        featuredImages.add(R.drawable.featured_item1);
        featuredImages.add(R.drawable.featured_item2);
        featuredImages.add(R.drawable.featured_item3);

        for (Integer image : featuredImages) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
            imageView.setImageResource(image);
            imageView.setContentDescription("Featured Item");
            featuredItemsContainer.addView(imageView);
        }
    }

    private void loadPopularItems() {
        // Placeholder for popular items - Update with actual data
        List<String> popularItems = new ArrayList<>();
        popularItems.add("User finding local services");
        popularItems.add("Community chats");
        popularItems.add("Positive reviews");

        for (String item : popularItems) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            itemLayout.setPadding(8, 8, 8, 8);

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
            imageView.setImageResource(R.drawable.popular_item1); // Update with appropriate drawable
            imageView.setContentDescription(item);

            LinearLayout textLayout = new LinearLayout(this);
            textLayout.setOrientation(LinearLayout.VERTICAL);
            textLayout.setPadding(8, 8, 8, 8);

            TextView title = new TextView(this);
            title.setText(item);
            title.setTextSize(16);

            TextView description = new TextView(this);
            description.setText("Description or review");
            description.setTextSize(14);

            textLayout.addView(title);
            textLayout.addView(description);
            itemLayout.addView(imageView);
            itemLayout.addView(textLayout);
            popularItemsContainer.addView(itemLayout);
        }
    }

    private void loadRecommendedItems() {
        // Placeholder for recommended items - Update with actual data
        List<String> recommendedItems = new ArrayList<>();
        recommendedItems.add("Recommended Item 1");
        recommendedItems.add("Recommended Item 2");
        recommendedItems.add("Recommended Item 3");

        for (String item : recommendedItems) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            itemLayout.setPadding(8, 8, 8, 8);

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
            imageView.setImageResource(R.drawable.recommended_item1); // Update with appropriate drawable
            imageView.setContentDescription(item);

            LinearLayout textLayout = new LinearLayout(this);
            textLayout.setOrientation(LinearLayout.VERTICAL);
            textLayout.setPadding(8, 8, 8, 8);

            TextView title = new TextView(this);
            title.setText(item);
            title.setTextSize(16);

            TextView description = new TextView(this);
            description.setText("Description or review");
            description.setTextSize(14);

            textLayout.addView(title);
            textLayout.addView(description);
            itemLayout.addView(imageView);
            itemLayout.addView(textLayout);
            recommendedItemsContainer.addView(itemLayout);
        }
    }
}