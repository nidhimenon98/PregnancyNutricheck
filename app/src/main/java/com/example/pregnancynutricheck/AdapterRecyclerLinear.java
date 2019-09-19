package com.example.pregnancynutricheck;

    import android.content.Context;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;

    public class AdapterRecyclerLinear extends RecyclerView.Adapter<AdapterRecyclerLinear.MyHolder> {

        	    Context context;
	    ArrayList<PojoLinear> pojoLinears;

        	    public AdapterRecyclerLinear(Context context, ArrayList<PojoLinear> pojoLinears) {
        	        this.context = context;
        	        this.pojoLinears = pojoLinears;
        	    }

        	    @NonNull
	    @Override
	    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        	        View view = LayoutInflater.from(context).inflate(R.layout.fragment_diet,viewGroup,false);

        	        MyHolder myHolder = new MyHolder(view);
        	        return myHolder;
        	    }

        	    @Override
	    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        	        myHolder.codeName.setText(pojoLinears.get(i).getCodeName());
        	    }

        	    @Override
	    public int getItemCount() {
        	        return pojoLinears.size();
        	    }

        	    public static class MyHolder extends RecyclerView.ViewHolder {

        	        TextView codeName, codeVersion;

        	        public MyHolder(@NonNull View itemView) {
            	            super(itemView);

            	            codeName = itemView.findViewById(R.id.code_name);
            	        }
	    }
	}
