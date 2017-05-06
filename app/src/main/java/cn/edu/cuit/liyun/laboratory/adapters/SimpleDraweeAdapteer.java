package cn.edu.cuit.liyun.laboratory.adapters;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class SimpleDraweeAdapteer {
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"imageUri", "loadding", "loadfailed"}, requireAll = false)
    public static void setImageUri(final SimpleDraweeView simpleDraweeView, final String uri, final boolean loadding, final boolean failed) {

        if (simpleDraweeView.getContext() instanceof Activity) {
            ((Activity) simpleDraweeView.getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!TextUtils.isEmpty(uri)) {
                        simpleDraweeView.setImageURI(Uri.parse(uri));
                    }
                }
            });
        }
    }
}
