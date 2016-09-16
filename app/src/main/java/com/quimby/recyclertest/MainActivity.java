package com.quimby.recyclertest;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLayoutManager;
    private LinearLayoutManager verticalLayoutManager;
    private RecycleAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.activityMain);
        horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(verticalLayoutManager);
        recycleAdapter = new RecycleAdapter();
        recyclerView.setAdapter(recycleAdapter);

        recycleAdapter.AddAll(FakeModel.GetAllFakeModels());
    }

    private class RecycleAdapter extends RecyclerView.Adapter<RecycleHolder>{
        private ArrayList<FakeModel> fakeModels = new ArrayList<>();
        public void AddAll(List<FakeModel> fakeModels)
        {
            int pos = getItemCount();
            this.fakeModels.addAll(fakeModels);
            notifyItemRangeChanged(pos,this.fakeModels.size());
        }
        @Override
        public RecycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent, false);
            return new RecycleHolder(view);
        }

        @Override
        public void onBindViewHolder(RecycleHolder holder, int position) {
            holder.bind(fakeModels.get(position));
        }

        @Override
        public int getItemCount() {
            return fakeModels.size();
        }
    }

    private static class FakeModel {
        private String author;
        private int imageId;


        public String getAuthor() {
            return author;
        }

        public int getImageId() {
            return imageId;
        }
        public FakeModel(String author, int imageId)
        {
            this.author = author;
            this.imageId = imageId;
        }
        public static List<FakeModel> GetAllFakeModels()
        {
            ArrayList<FakeModel> models = new ArrayList<>();
            models.add(new FakeModel("denis3",R.id.card_image));
            models.add(new FakeModel("denis",R.id.card_image));
            models.add(new FakeModel("denis1",R.id.card_image));
            models.add(new FakeModel("denis2",R.id.card_image));
            models.add(new FakeModel("denis3",R.id.card_image));
            models.add(new FakeModel("denis4",R.id.card_image));
            models.add(new FakeModel("denis11",R.id.card_image));

            return models;
        }
    }

    private class RecycleHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public RecycleHolder(View itemView) {
                super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tittle);
            imageView = (ImageView) itemView.findViewById(R.id.card_image);
        }

        public void bind(FakeModel modelItem) {

            imageView = (ImageView) itemView.findViewById(R.id.card_image);
//            imageView.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(), modelItem.getImageId()));
            textView.setText(modelItem.getAuthor());
        }
    }
}
