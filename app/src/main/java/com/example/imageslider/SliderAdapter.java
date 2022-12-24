package com.example.imageslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderViewAdapterViewHolder> {


    //list for storing urls of images
    private final List<SliderData> mSliderItems;

    //constructor
    public SliderAdapter(MainActivity mainActivity, List<SliderData> mSliderItems) {
        this.mSliderItems = mSliderItems;
    }

    @Override
    public SliderViewAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return  new SliderViewAdapterViewHolder(inflate);
    }

    //data for the slider View
    @Override
    public void onBindViewHolder(SliderViewAdapterViewHolder viewHolder, int position) {
        final SliderData sliderItem = mSliderItems.get(position);

        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImgUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderViewAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;

        public SliderViewAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.myimage);
            this.itemView = itemView;
        }
    }
}
