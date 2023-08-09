package com.example.attendenceapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class InforActivity extends Activity {
    RecyclerView rlContainer2;
    DatabaseReference reference;
    SeeInfoAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_info);
        rlContainer2 = findViewById(R.id.rlContainer2);
        reference = FirebaseDatabase.getInstance().getReference("teachers");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    SeeInfoModule items = dataSnapshot.getValue(SeeInfoModule.class);
                    items.setId(dataSnapshot.getKey());
                    Query query = reference.child(items.getId());
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            items.setName(snapshot.child("name").getValue(String.class));
//                            items.setPresent(snapshot.child("attendance").getValue(String.class));
                            long present = snapshot.child("attendance").getChildrenCount();
                            long leave = snapshot.child("leave").getChildrenCount();
                            items.setPresentCont(present);
                            items.setLeaveCount(leave);
                            long absent = 30 - (present + leave);
                            items.setAbsentCount(absent);
                            items.setMobile(snapshot.child("phone").getValue(String.class));
                            Log.d("Firebase Test", "onDataChange:\n" + "item from firebase" + items.getPresentCont());


                            rlContainer2.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                            FirebaseRecyclerOptions<SeeInfoModule> options = new FirebaseRecyclerOptions.Builder<SeeInfoModule>()
                                    .setQuery(reference,SeeInfoModule.class).build();
                            adapter = new SeeInfoAdapter(options);
                            rlContainer2.setAdapter(adapter);
                            adapter.startListening();
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.startListening();
    }
}
