package example.com.sunshine.download.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.sunshine.R;
import example.com.sunshine.dagger.DaggerFragmentComponent;
import example.com.sunshine.dagger.FragmentMobule;
import example.com.sunshine.download.Adapter.RecommendAdapter;
import example.com.sunshine.download.Http.Configuration;
import example.com.sunshine.download.Http.SystemUtils;
import example.com.sunshine.download.Http.entity.BaseResponse;
import example.com.sunshine.download.View.LoginView;
import example.com.sunshine.download.request.CategoryRadioInfo;
import example.com.sunshine.download.request.CnrLog;
import example.com.sunshine.download.request.HomeBottomResponse;
import example.com.sunshine.download.request.HttpManger;
import example.com.sunshine.download.request.JsonDataFactory;
import example.com.sunshine.download.request.StringTool;
import example.com.sunshine.util.Util;

/**
 * Created by qianxiangsen on 2017/5/3.
 */

public class RecommendFragment extends BaseFragment implements LoginView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    RecommendAdapter recommendAdapter;

    @Inject
    public RecommendFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView(Bundle savedInstanceState, View rootView) {
        DaggerFragmentComponent.builder().
                fragmentMobule(new
                        FragmentMobule(this)).build().inject(this);

        ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        showLoading();

        loadHomeBottomData();
    }

    // 加载底部分类数据
    private void loadHomeBottomData() {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("sn", SystemUtils.getMd5UniqueID(this.getActivity()));
//        HttpManger.getInstance(getActivity(), this).sendPostRequest(Configuration.HOME_BOTTOM_URL, map, true);

        List<CategoryRadioInfo> categoryRadioInfos = JsonDataFactory.getHomeCategoryList(CnrLog.bottonjson);
        HomeBottomResponse bottomResponse = new HomeBottomResponse();
        bottomResponse.setCategoryRadioInfos(categoryRadioInfos);
        onDataReady(bottomResponse);
    }


    @Override
    public void onDataReady(BaseResponse response) {

        if (response instanceof HomeBottomResponse) {
            refreshView();
            HomeBottomResponse bottomResponse = (HomeBottomResponse) response;
            if (!StringTool.isListValidate(bottomResponse.getCategoryRadioInfos().get(0).getRadioInfos())) {
                showEmptyView("没数据");
            }
            recommendAdapter = new RecommendAdapter(bottomResponse.getCategoryRadioInfos().get(0).getRadioInfos());
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            recyclerView.setAdapter(recommendAdapter);
            recommendAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Util.setIntnetPlay(getActivity().getSupportFragmentManager(),
                            R.id.fragment_play,Util.PLAY_TAG_FRAGMENT);
                }
            });
        }
    }

    @Override
    protected void OnClick(View v) {

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }


    @Override
    public void reLoadData() {
        super.reLoadData();
        initData();
    }

    @Override
    protected View getLoadingTargetView() {
        return recyclerView;
    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void setUsernameError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public void hideProgress() {

    }
}
