package rs.cod3rs.shopifine.hateoas.products;

import java.util.List;

import rs.cod3rs.shopifine.hateoas.CollectionLinks;

public class ProductCollectionResponse {

    private List<ProductResponseData> data;

    private CollectionLinks links;

    public ProductCollectionResponse() {
        super();
    }

    public List<ProductResponseData> getData() {
        return data;
    }

    public void setData(final List<ProductResponseData> data) {
        this.data = data;
    }

    public CollectionLinks getLinks() {
        return links;
    }

    public void setLinks(final CollectionLinks links) {
        this.links = links;
    }
}
