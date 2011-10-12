package org.exoplatform.controller.social;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.exoplatform.model.SocialCommentInfo;
import org.exoplatform.model.SocialLikeInfo;
import org.exoplatform.singleton.LocalizationHelper;
import org.exoplatform.singleton.SocialDetailHelper;
import org.exoplatform.singleton.SocialServiceHelper;
import org.exoplatform.social.client.api.model.RestActivity;
import org.exoplatform.social.client.api.model.RestComment;
import org.exoplatform.social.client.api.model.RestIdentity;
import org.exoplatform.social.client.api.model.RestLike;
import org.exoplatform.social.client.api.model.RestProfile;
import org.exoplatform.social.client.api.service.QueryParams;
import org.exoplatform.social.client.core.service.QueryParamsImpl;
import org.exoplatform.utils.UserTask;
import org.exoplatform.widget.WaitingDialog;
import org.exoplatform.widget.WarningDialog;

import android.content.Context;
import android.util.Log;

public class SocialDetailLoadTask extends UserTask<Void, Void, Integer> {
  private RestActivity                 selectedRestActivity;

  private LinkedList<SocialLikeInfo>   likeLinkedList    = new LinkedList<SocialLikeInfo>();

  private ArrayList<SocialCommentInfo> socialCommentList = new ArrayList<SocialCommentInfo>();

  private SocialDetailWaitingDialog    _progressDialog;

  private Context                      mContext;

  private String                       loadingData;

  private String                       youText;

  private String                       okString;

  private String                       titleString;

  private String                       contentString;

  private SocialDetailController       detailController;

  private RestProfile                  profile;

  private String                       title;

  private long                         postedTime;

  public SocialDetailLoadTask(Context context, SocialDetailController controller) {
    mContext = context;
    detailController = controller;
    changeLanguage();
  }

  @Override
  public void onPreExecute() {
    _progressDialog = new SocialDetailWaitingDialog(mContext, null, loadingData);
    _progressDialog.show();
  }

  @Override
  public Integer doInBackground(Void... params) {

    try {
      String activityId = SocialDetailHelper.getInstance().getActivityId();
      QueryParams queryParams = new QueryParamsImpl();
      queryParams.append(QueryParams.NUMBER_OF_LIKES_PARAM.setValue(10));
      queryParams.append(QueryParams.NUMBER_OF_COMMENTS_PARAM.setValue(10));
      selectedRestActivity = SocialServiceHelper.getInstance()
                                                .getActivityService()
                                                .get(activityId, queryParams);
      SocialDetailHelper.getInstance().setLiked(false);
      profile = selectedRestActivity.getPosterIdentity().getProfile();
      title = selectedRestActivity.getTitle();
      postedTime = selectedRestActivity.getPostedTime();
      List<RestIdentity> likeList = selectedRestActivity.getAvailableLikes();
      List<RestComment> commentList = selectedRestActivity.getAvailableComments();
      if (likeList != null) {
        for (RestIdentity like : likeList) {
          SocialLikeInfo socialLike = new SocialLikeInfo();
          String identity = like.getId();
          if (identity.equalsIgnoreCase(SocialServiceHelper.getInstance().getUserId())) {
            socialLike.setLikeName(youText);
            likeLinkedList.addFirst(socialLike);
            SocialDetailHelper.getInstance().setLiked(true);
          } else {
            socialLike.setLikeName(like.getProfile().getFullName());
            likeLinkedList.add(socialLike);
          }

        }
      }
      System.out.println("commentList" + commentList.size());

      if (commentList != null) {
        for (RestComment comment : commentList) {
          SocialCommentInfo socialComment = new SocialCommentInfo();
          String identity = comment.getIdentityId();
          System.out.println("identity " + identity);
//          RestIdentity restId = (RestIdentity) SocialServiceHelper.getInstance()
//                                                                  .getIdentityService()
//                                                                  .get(identity);
          RestIdentity restId = comment.getIdentity();
          System.out.println("RestIdentity ");
          RestProfile profile = restId.getProfile();

          socialComment.setCommentId(identity);
          System.out.println("fullname " + profile.getFullName());
          socialComment.setCommentName(profile.getFullName());
          socialComment.setImageUrl(profile.getAvatarUrl());
          socialComment.setCommentTitle(comment.getText());
          socialComment.setPostedTime(comment.getPostedTime());

          socialCommentList.add(socialComment);
        }
      }

      return 1;
    } catch (RuntimeException e) {
      return 0;
    }
  }

  @Override
  public void onPostExecute(Integer result) {
    if (result == 1) {
      detailController.setComponentInfo(profile, title, postedTime);
      detailController.createCommentList(socialCommentList);
      detailController.setLikeInfo(likeLinkedList);
    } else {
      WarningDialog dialog = new WarningDialog(mContext, titleString, contentString, okString);
      dialog.show();
    }
    _progressDialog.dismiss();

  }

  private void changeLanguage() {
    LocalizationHelper location = LocalizationHelper.getInstance();
    loadingData = location.getString("LoadingData");
    youText = location.getString("You");
    okString = location.getString("OK");
    titleString = location.getString("Warning");
    contentString = location.getString("ConnectionError");

  }

  private class SocialDetailWaitingDialog extends WaitingDialog {

    public SocialDetailWaitingDialog(Context context, String titleString, String contentString) {
      super(context, titleString, contentString);
    }

    @Override
    public void onBackPressed() {
      super.onBackPressed();
      detailController.onCancelLoad();
    }

  }
}
