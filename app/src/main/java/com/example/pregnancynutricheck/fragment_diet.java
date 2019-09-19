package com.example.pregnancynutricheck;
	import android.os.Bundle;
	import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

        	public class fragment_diet extends AppCompatActivity {

        	    RecyclerView recyclerView;
	    		RecyclerView.LayoutManager layoutManager;

        	    AdapterRecyclerLinear adapterRecyclerLinear;

        	    ArrayList<PojoLinear> list;

        	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
        	        super.onCreate(savedInstanceState);
        	        setContentView(R.layout.fragment_diet);
        	        linearList();

        	        recyclerView = findViewById(R.id.rv);
        	        recyclerView.setHasFixedSize(true);
        	        layoutManager = new LinearLayoutManager(this);
        	        recyclerView.setLayoutManager(layoutManager);

        	        adapterRecyclerLinear = new AdapterRecyclerLinear(this,list);
        	        recyclerView.setAdapter(adapterRecyclerLinear);
        	    }
	    private void linearList(){

        	        list = new ArrayList<PojoLinear>();
        	        list.add(new PojoLinear("Pie"));
        	        list.add(new PojoLinear("Oreo"));
        	        list.add(new PojoLinear("Nougat"));
        	        list.add(new PojoLinear("Marshmallow"));
        	        list.add(new PojoLinear("Lolipop"));
        	        list.add(new PojoLinear("Kitkat"));
        	        list.add(new PojoLinear("Jelly Bean"));
        	        list.add(new PojoLinear("Icecream sandwitch"));
        	        list.add(new PojoLinear("Honey Comb"));
        	        list.add(new PojoLinear("Gingerbreak"));
        	    }
	}
