package com.example.employe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private Context context;
    private List<Employee> employeeList;

    public EmployeeAdapter(Context context, List<Employee> employees){
        this.context = context;
        employeeList = employees;
    }
    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        Employee employee1 = employeeList.get(position);
//        holder.id.setText(employee.getId().toString());
        holder.name.setText(employee1.getName());
        holder.email.setText(employee1.getEmail());
//        holder.phonenumber.setText(employee.getPhone().toString());
//        holder.Address.setText(employee.getAddress().toString());
//        holder.company_name.setText(employee.getCompany().toString());
//        holder.website.setText(employee.getWebsite().toString());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetaillActivity.class);
                Bundle bundle  = new Bundle();
                bundle.putString("id", employee1.getId());
                bundle.putString("name", employee1.getName());
                bundle.putString("email", employee1.getEmail());
                bundle.putString("phone", employee1.getPhone());
                bundle.putString("address",employee1.getAddress());
                bundle.putString("website", employee1.getWebsite());
                bundle.putString("company",employee1.getCompany());
              intent.putExtras(bundle);
              context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder{
        TextView name, email;
        ConstraintLayout constraintLayout;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            email = itemView.findViewById(R.id.textView2);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
