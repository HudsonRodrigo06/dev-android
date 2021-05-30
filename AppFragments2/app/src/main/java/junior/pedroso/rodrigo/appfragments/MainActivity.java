package junior.pedroso.rodrigo.appfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btFrag1;
    private Button btFrag2;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btFrag1 = this.findViewById(R.id.btFrag1);
        btFrag2 = this.findViewById(R.id.btFrag2);

        //fragment
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();

        fm = this.getSupportFragmentManager();

        btFrag1.setOnClickListener(e -> { trocarFragmentTwo(); });
        btFrag2.setOnClickListener(e -> { trocarFragmentOne(); });

    }

    public void trocarFragmentTwo() {

        ft = fm.beginTransaction();
        ft.replace(R.id.fragment, oneFragment);
        ft.commit();

    }

    public void trocarFragmentOne() {

        ft = fm.beginTransaction();
        ft.replace(R.id.fragment, twoFragment);
        ft.commit();

    }


}