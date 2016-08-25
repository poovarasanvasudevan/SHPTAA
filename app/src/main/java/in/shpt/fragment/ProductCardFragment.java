package in.shpt.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.math.RoundingMode;

import carbon.widget.CardView;
import carbon.widget.ImageView;
import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.activity.FullProductActivity_;
import in.shpt.models.products.Product;


public class ProductCardFragment extends Fragment {

    Product allProduct;
    TextView productTitle, productDescription, productPrice;
    CardView fullCard;
    ImageView productImage;
    String imageUrl = "";



    public ProductCardFragment() {
        // Required empty public constructor
    }


    public static ProductCardFragment newInstance(Product param1) {
        ProductCardFragment fragment = new ProductCardFragment();
        Bundle args = new Bundle();
        args.putParcelable("Product", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            allProduct = getArguments().getParcelable("Product");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.product_swipe_card, container, false);

        productTitle = (TextView) v.findViewById(R.id.productTitle);
        productDescription = (TextView) v.findViewById(R.id.productDescription);
        productPrice = (TextView) v.findViewById(R.id.productPrice);
        fullCard = (CardView) v.findViewById(R.id.fullcard);
        productImage = (ImageView) v.findViewById(R.id.productImage);

        fullCard.setOnClickListener(fullCardListener);

        productPrice.setText("₹ " + new BigDecimal(allProduct.getPrice()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        productDescription.setText(allProduct.getMeta_description());
        productTitle.setText(allProduct.getName());

        boolean isJpg = allProduct.getImage().contains(".jpg");




        imageUrl = allProduct.getImage().replace(".png", "");
        imageUrl = imageUrl.replace(".jpg", "");
        imageUrl = imageUrl + "-550x550";

        if (isJpg)
            imageUrl = imageUrl + ".jpg";
        else
            imageUrl = imageUrl + ".png";


        String image = "https://shptqa.dev4srcm.org/image/cache/" + imageUrl;
        Picasso.with(getContext())
                .load("https://shptqa.dev4srcm.org/image/cache/" + imageUrl)
                .resize(220, 300)
                .into(productImage);



        return v;
    }


    View.OnClickListener fullCardListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FullProductActivity_
                    .intent(getContext())
                    .product(allProduct)
                    .start();
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
