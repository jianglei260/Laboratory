package cn.edu.cuit.liyun.laboratory.base;
public interface Refreshable {
    public void onLoadMore(OnComplete complete);

    public void onRefresh(OnComplete complete);

    public interface OnComplete{
        public void onComplete();
    }
}