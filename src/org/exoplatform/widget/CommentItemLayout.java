package org.exoplatform.widget;

import greendroid.widget.AsyncImageView;

import org.exoplatform.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CommentItemLayout extends RelativeLayout {
  public AsyncImageView comAvatarImage;

  public TextView       comTextViewName;

  public TextView       comTextViewMessage;

  public TextView       comPostedTime;

  public CommentItemLayout(Context context) {
    super(context);

    LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflate.inflate(R.layout.activitydisplayviewcell, this);
    comAvatarImage = (AsyncImageView) view.findViewById(R.id.imageView_Avatar);
    comTextViewName = (TextView) view.findViewById(R.id.textView_Name);
    comTextViewMessage = (TextView) view.findViewById(R.id.textView_Message);
    comPostedTime = (TextView) view.findViewById(R.id.textView_Time);
  }
}
