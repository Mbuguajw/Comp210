import java.util.ArrayList;

public class ProductImpl implements Product {

  private static ArrayList<Product> productList;
  private static String nameProduct;
  private static String categories;

  private ProductImpl() {
    //Leave me empty
  }

  public static Product create(String name) {
    if(productList == null) {
      productList = new ArrayList<Product>();
    }
    productList.add(new ProductImpl());
    nameProduct = name;
    categories = "uncategorized";
    return productList.get(productList.size() - 1);
  }
  @Override
  public String getName() {
    return nameProduct;
  }

  @Override
  public String getCategory() {
    return categories;
  }

  @Override
  public void setCategory(String category) {
    categories = category;
  }
}
