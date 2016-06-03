package com.koalasubproductions.bolets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PostresListFragment extends Fragment {

    private static final ArrayList<String> list = new ArrayList<String>();
    private static final ArrayList<Integer> drawablesList = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_mushroom_list, container, false);
        setupRecyclerView(rv);
        list.clear();
        drawablesList.clear();
        getList();
        return rv;
    }


    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), list));
    }


    private void getList (){
        String nomString;
        int drawable;
        for (Recepta item : Recepta.Postres_ITEMS) {
            nomString = getResources().getString(item.getNomCurt());
            drawable = item.getIdImatge();
            list.add(nomString);
            drawablesList.add(drawable);
        }
    }


    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mValues;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View mView;
            public final ImageView mImageView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.avatar);
                mTextView = (TextView) view.findViewById(android.R.id.text1);

            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTextView.getText();
            }
        }


        public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.mBoundString = mValues.get(position);
            holder.mTextView.setText(mValues.get(position));


            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String fName = "Postres";
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ReceptaDetailActivity.class);
                    intent.putExtra(ReceptaDetailActivity.ARG_SECTION_TITLE, holder.mBoundString);
                    intent.putExtra(ReceptaDetailActivity.RECEP_TYPE, fName);

                    context.startActivity(intent);
                }
            });


            Glide.with(holder.mImageView.getContext())
                    .load(drawablesList.get(position))
                    .fitCenter()
                    .into(holder.mImageView);

        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }

}
