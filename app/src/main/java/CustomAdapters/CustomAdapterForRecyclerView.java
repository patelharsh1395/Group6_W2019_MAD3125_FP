package CustomAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harsh.group6_w2019_mad3125_fp.R;

import java.util.ArrayList;
import java.util.EmptyStackException;

import model.abstracts.Employee;
import model.enums.gender;

public class CustomAdapterForRecyclerView extends RecyclerView.Adapter<CustomAdapterForRecyclerView.ViewHolder> {




    public interface SetCustomClickListener{
        public  void customOnClick(Employee e);
    }



    ArrayList<Employee> arrayList;
    Context context;
    SetCustomClickListener listener;


    public CustomAdapterForRecyclerView(ArrayList<Employee> arrayList, Context context, SetCustomClickListener listener) {
        this.arrayList = arrayList;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.card_layout_employee, viewGroup , false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.bind(this.arrayList.get(i), this.listener);
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        TextView name;
        TextView gender;
        TextView age;


        public ViewHolder(@NonNull View View) {
            super(View);
            name = itemView.findViewById(R.id.emp_name);
            gender = itemView.findViewById(R.id.emp_gender);
            age = itemView.findViewById(R.id.emp_age);
        }


        public  void bind(final Employee e , final SetCustomClickListener listener)
        {
            if(e.getGen() == model.enums.gender.MALE )
            {
                gender.setText("MALE");
            }
            else
            {
                gender.setText("FEMALE");
            }

            name.setText("Name : "+e.getName());
            age.setText("Age : "+e.getAge());

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.customOnClick(e);
                    }
                });
        }
    }
}
