package org.exoplatform.widget;

import org.exoplatform.R;
import org.exoplatform.controller.social.ComposeMessageController;
import org.exoplatform.singleton.LocalizationHelper;
import org.exoplatform.ui.DocumentActionDialog;
import org.exoplatform.ui.social.SocialPhotoAlbums;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AddPhotoDialog extends Dialog implements android.view.View.OnClickListener {

  private TextView                 titleView;

  private Button                   takePhotoButton;

  private Button                   libraryButton;

  private Button                   cancelButton;

  private String                   cancelText;

  private Context                  mContext;

  private String                   addPhotoTitle;

  private String                   takePhotoText;

  private String                   photoLibraryText;

  private ComposeMessageController messageController;

  private DocumentActionDialog     fileActionDialog;

  public AddPhotoDialog(Context context, DocumentActionDialog activity) {
    super(context);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.add_photo_dialog_layout);
    mContext = context;
    fileActionDialog = activity;

    init();

  }

  public AddPhotoDialog(Context context, ComposeMessageController controller) {
    super(context);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.add_photo_dialog_layout);
    mContext = context;
    messageController = controller;

    init();
  }

  private void init() {

    changeLanguage();

    titleView = (TextView) findViewById(R.id.add_photo_dialog_title_view);
    titleView.setText(addPhotoTitle);
    takePhotoButton = (Button) findViewById(R.id.add_photo_take_button);
    takePhotoButton.setText(takePhotoText);
    takePhotoButton.setOnClickListener(this);
    libraryButton = (Button) findViewById(R.id.add_photo_library_button);
    libraryButton.setText(photoLibraryText);
    libraryButton.setOnClickListener(this);
    cancelButton = (Button) findViewById(R.id.add_photo_cancel_button);
    cancelButton.setText(cancelText);
    cancelButton.setOnClickListener(this);

  }

  public void onClick(View view) {
    if (view.equals(takePhotoButton)) {
      dismiss();
      if (messageController == null)
        fileActionDialog._documentActionAdapter.initCamera();
      else
        messageController.initCamera();
    }
    if (view.equals(libraryButton)) {
      dismiss();
      Intent intent = new Intent(mContext, SocialPhotoAlbums.class);
      mContext.startActivity(intent);

    }
    if (view.equals(cancelButton)) {
      dismiss();
    }
  }

  private void changeLanguage() {
    LocalizationHelper bundle = LocalizationHelper.getInstance();
    cancelText = bundle.getString("Cancel");
    addPhotoTitle = bundle.getString("AddAPhoto");
    takePhotoText = bundle.getString("TakeAPhoto");
    photoLibraryText = bundle.getString("PhotoLibrary");
  }
}
