package rs.cod3rs.shopifine.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;
import java.util.stream.Collectors;

import rs.cod3rs.shopifine.R;
import rs.cod3rs.shopifine.adapter.ProductsAdapter;
import rs.cod3rs.shopifine.domain.Product;
import rs.cod3rs.shopifine.hateoas.ProductResponseData;
import rs.cod3rs.shopifine.http.Products;

@EActivity(R.layout.activity_products)
public class ProductsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @RestService
    Products products;

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.products)
    ListView productsView;

    @ViewById
    DrawerLayout drawerLayout;

    @ViewById
    NavigationView navigationView;

    @Bean
    ProductsAdapter adapter;

    @AfterViews
    void bindAdapter() {
        productsView.setAdapter(adapter);
    }

    @AfterViews
    void setToolbar() {
        setSupportActionBar(toolbar);
    }

    @AfterViews
    void getData() {
        getProducts();
    }

    @ItemClick
    void productsItemClicked(final Product product) {
        Log.i(ProductsActivity.class.getSimpleName(), String.format("Clicked on product %s", product.name));
    }

    @AfterViews
    void setDrawer() {
        // FIXME Better implementation
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Background
    void getProducts() {
        final List<Product> p = products.retrieveAll().getData().stream()
                .map(ProductResponseData::toDomain).collect(Collectors.toList());

        updateList(p);
    }

    @UiThread
    void updateList(final List<Product> p) {
        adapter.products = p;
        productsView.setAdapter(adapter);
    }
}
