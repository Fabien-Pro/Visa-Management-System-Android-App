package com.example.visamanagementsystem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class ApplicationAdapterClass extends RecyclerView.Adapter<ApplicationAdapterClass.ViewHolder>{
    List<ApplicationModelClass> applicant;
    Context context;
    DBHelper DB;
    public ApplicationAdapterClass(List<ApplicationModelClass> applicant, Context context) {
        this.applicant=applicant;
        this.context = context;
        DB= new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.application_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        final ApplicationModelClass applicationModelClass = applicant.get(position);

        holder.textViewID.setText(Integer.toString(applicationModelClass.getId()));
        holder.editText_Name.setText(applicationModelClass.getName());
        holder.editText_Email.setText(applicationModelClass.getEmail());
        holder.editText_Res_country.setText(applicationModelClass.getRes_country());
        holder.editText_Dob.setText(applicationModelClass.getDob());
        holder.editText_Pov.setText(applicationModelClass.getPov());
        holder.editText_Dot.setText(applicationModelClass.getDot());
        holder.editText_Doe.setText(applicationModelClass.getDoe());
        holder.editText_Doi.setText(applicationModelClass.getDoi());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();
                String stringRes_country = holder.editText_Res_country.getText().toString();
                String stringDob = holder.editText_Dob.getText().toString();
                String stringPov = holder.editText_Pov.getText().toString();
                String stringDot = holder.editText_Dot.getText().toString();
                String stringDoi = holder.editText_Doi.getText().toString();
                String stringDoe = holder.editText_Doe.getText().toString();

                DB.updateApplicant(new ApplicationModelClass(applicationModelClass.getId(),stringName,stringEmail,stringRes_country,stringDob,stringPov,stringDot,stringDoi,stringDoe));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.deleteApplicant(applicationModelClass.getId());
                applicant.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return applicant.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_Res_country;
        EditText editText_Dob;
        EditText editText_Pov;
        EditText editText_Dot;
        EditText editText_Doi;
        EditText editText_Doe;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.textViewID);
            editText_Name = itemView.findViewById(R.id.editText_Name);
            editText_Email = itemView.findViewById(R.id.editText_Email);
            editText_Res_country = itemView.findViewById(R.id.editText_Res_country);
            editText_Dob = itemView.findViewById(R.id.editText_Dob);
            editText_Pov = itemView.findViewById(R.id.editText_Pov);
            editText_Dot = itemView.findViewById(R.id.editText_Dot);
            editText_Doi = itemView.findViewById(R.id.editText_Doi);
            editText_Doe = itemView.findViewById(R.id.editText_Doe);
            button_delete = itemView.findViewById(R.id.button_Delete);
            button_Edit = itemView.findViewById(R.id.button_Edit);

        }
    }
}



