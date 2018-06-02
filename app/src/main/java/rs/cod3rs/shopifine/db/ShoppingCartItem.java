package rs.cod3rs.shopifine.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import rs.cod3rs.shopifine.domain.Product;

@DatabaseTable(tableName = "shopping_cart_items")
public class ShoppingCartItem {

    @DatabaseField(columnName = "id", generatedId = true)
    public Integer id;

    @DatabaseField(columnName = "user_id")
    public Integer userId;

    @DatabaseField(columnName = "product_id")
    public Long productId;

    @DatabaseField(columnName = "product", dataType = DataType.SERIALIZABLE)
    public Product product;

    @DatabaseField(columnName = "quantity")
    public Integer quantity;

    public ShoppingCartItem() {
        super();
    }

    public ShoppingCartItem(final Integer userId, final Product product) {
        this.userId = userId;
        this.productId = product.id;
        this.product = product;
        this.quantity = 1;
    }

    public ShoppingCartItem(final Integer userId, final Product product, final Integer quantity) {
        this.userId = userId;
        this.productId = product.id;
        this.product = product;
        this.quantity = quantity;
    }
}
