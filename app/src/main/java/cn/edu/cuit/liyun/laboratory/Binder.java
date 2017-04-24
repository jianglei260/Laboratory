package cn.edu.cuit.liyun.laboratory;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AbsSpinner;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.myworld.ide.struct.op.Invoker;
import com.myworld.ide.struct.op.Widget;

/**
 * Created by jianglei on 2017/4/12.
 */

public class Binder {
    private Widget widget;

    public Binder(Widget widget) {
        this.widget = widget;
    }

    public static AutoCompleteTextViewBinder autoCompleteTextView(Widget<AutoCompleteTextView> autoCompleteTextView) {
        AutoCompleteTextViewBinder autoCompleteTextViewBinder = new AutoCompleteTextViewBinder(autoCompleteTextView);
        return autoCompleteTextViewBinder;
    }

    public static ViewBinder view(Widget<View> view) {
        ViewBinder viewBinder = new ViewBinder(view);
        return viewBinder;
    }

    public static ListViewBinder listView(Widget<ListView> listView) {
        ListViewBinder listViewBinder = new ListViewBinder(listView);
        return listViewBinder;
    }

    public static TimePickerBinder timePicker(Widget<TimePicker> timePicker) {
        TimePickerBinder timePickerBinder = new TimePickerBinder(timePicker);
        return timePickerBinder;
    }

    public static ScrollViewBinder scrollView(Widget<ScrollView> scrollView) {
        ScrollViewBinder scrollViewBinder = new ScrollViewBinder(scrollView);
        return scrollViewBinder;
    }

    public static AdapterViewBinder adapterView(Widget<AdapterView> adapterView) {
        AdapterViewBinder adapterViewBinder = new AdapterViewBinder(adapterView);
        return adapterViewBinder;
    }

    public static WebViewBinder webView(Widget<WebView> webView) {
        WebViewBinder webViewBinder = new WebViewBinder(webView);
        return webViewBinder;
    }

    public static SwitchCompatBinder switchCompat(Widget<SwitchCompat> switchCompat) {
        SwitchCompatBinder switchCompatBinder = new SwitchCompatBinder(switchCompat);
        return switchCompatBinder;
    }

    public static SimpleDraweeViewBinder simpleDraweeView(Widget<com.facebook.drawee.view.SimpleDraweeView> simpleDraweeView) {
        SimpleDraweeViewBinder simpleDraweeViewBinder = new SimpleDraweeViewBinder(simpleDraweeView);
        return simpleDraweeViewBinder;
    }

    public static CalendarViewBinder calendarView(Widget<CalendarView> calendarView) {
        CalendarViewBinder calendarViewBinder = new CalendarViewBinder(calendarView);
        return calendarViewBinder;
    }

    public static ImageViewBinder imageView(Widget<ImageView> imageView) {
        ImageViewBinder imageViewBinder = new ImageViewBinder(imageView);
        return imageViewBinder;
    }

    public static ViewPagerBinder viewPager(Widget<ViewPager> viewPager) {
        ViewPagerBinder viewPagerBinder = new ViewPagerBinder(viewPager);
        return viewPagerBinder;
    }

    public static TextViewBinder textView(Widget<TextView> textView) {
        TextViewBinder textViewBinder = new TextViewBinder(textView);
        return textViewBinder;
    }

    public static AbsListViewBinder absListView(Widget<AbsListView> absListView) {
        AbsListViewBinder absListViewBinder = new AbsListViewBinder(absListView);
        return absListViewBinder;
    }

    public static DatePickerBinder datePicker(Widget<DatePicker> datePicker) {
        DatePickerBinder datePickerBinder = new DatePickerBinder(datePicker);
        return datePickerBinder;
    }

    public static CompoundButtonBinder compoundButton(Widget<CompoundButton> compoundButton) {
        CompoundButtonBinder compoundButtonBinder = new CompoundButtonBinder(compoundButton);
        return compoundButtonBinder;
    }

    public static SwitchBinder _switch(Widget<Switch> _switch) {
        SwitchBinder switchBinder = new SwitchBinder(_switch);
        return switchBinder;
    }

    public static RadioGroupBinder radioGroup(Widget<RadioGroup> radioGroup) {
        RadioGroupBinder radioGroupBinder = new RadioGroupBinder(radioGroup);
        return radioGroupBinder;
    }

    public static SwipeRefreshLayoutBinder swipeRefreshLayout(Widget<SwipeRefreshLayout> swipeRefreshLayout) {
        SwipeRefreshLayoutBinder swipeRefreshLayoutBinder = new SwipeRefreshLayoutBinder(swipeRefreshLayout);
        return swipeRefreshLayoutBinder;
    }

    public static TableLayoutBinder tableLayout(Widget<TableLayout> tableLayout) {
        TableLayoutBinder tableLayoutBinder = new TableLayoutBinder(tableLayout);
        return tableLayoutBinder;
    }

    public static CardViewBinder cardView(Widget<android.support.v7.widget.CardView> cardView) {
        CardViewBinder cardViewBinder = new CardViewBinder(cardView);
        return cardViewBinder;
    }

    public static EditTextBinder editText(Widget<EditText> editText) {
        EditTextBinder editTextBinder = new EditTextBinder(editText);
        return editTextBinder;
    }

    public static AbsSpinnerBinder absSpinner(Widget<AbsSpinner> absSpinner) {
        AbsSpinnerBinder absSpinnerBinder = new AbsSpinnerBinder(absSpinner);
        return absSpinnerBinder;
    }

    public static RecyclerViewBinder recyclerView(Widget<android.support.v7.widget.RecyclerView> recyclerView) {
        RecyclerViewBinder recyclerViewBinder = new RecyclerViewBinder(recyclerView);
        return recyclerViewBinder;
    }

    public static TabHostBinder tabHost(Widget<TabHost> tabHost) {
        TabHostBinder tabHostBinder = new TabHostBinder(tabHost);
        return tabHostBinder;
    }

    public static NumberPickerBinder numberPicker(Widget<NumberPicker> numberPicker) {
        NumberPickerBinder numberPickerBinder = new NumberPickerBinder(numberPicker);
        return numberPickerBinder;
    }

    public static SeekBarBinder seekBar(Widget<SeekBar> seekBar) {
        SeekBarBinder seekBarBinder = new SeekBarBinder(seekBar);
        return seekBarBinder;
    }

    public static SearchViewBinder searchView(Widget<SearchView> searchView) {
        SearchViewBinder searchViewBinder = new SearchViewBinder(searchView);
        return searchViewBinder;
    }

    public static RatingBarBinder ratingBar(Widget<RatingBar> ratingBar) {
        RatingBarBinder ratingBarBinder = new RatingBarBinder(ratingBar);
        return ratingBarBinder;
    }

    public static NestedScrollViewBinder nestedScrollView(Widget<NestedScrollView> nestedScrollView) {
        NestedScrollViewBinder nestedScrollViewBinder = new NestedScrollViewBinder(nestedScrollView);
        return nestedScrollViewBinder;
    }

    public static ViewGroupBinder viewGroup(Widget<ViewGroup> viewGroup) {
        ViewGroupBinder viewGroupBinder = new ViewGroupBinder(viewGroup);
        return viewGroupBinder;
    }

    static class ViewGroupBinder extends ViewBinder {
        com.myworld.ide.struct.op.Widget<ViewGroup> widget;

        public ViewGroupBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void animateLayoutChanges(com.myworld.ide.struct.op.FieldObject<Boolean> animateLayoutChanges) {
            Invoker.getInstance().bindAttr("android:animateLayoutChanges", widget, animateLayoutChanges);
        }

        public void onAnimationEnd(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewGroupBindingAdapter.OnAnimationEnd> onAnimationEnd) {
            Invoker.getInstance().bindAttr("android:onAnimationEnd", widget, onAnimationEnd);
        }

        public void onAnimationStart(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewGroupBindingAdapter.OnAnimationStart> onAnimationStart) {
            Invoker.getInstance().bindAttr("android:onAnimationStart", widget, onAnimationStart);
        }

        public void onChildViewRemoved(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewGroupBindingAdapter.OnChildViewRemoved> onChildViewRemoved) {
            Invoker.getInstance().bindAttr("android:onChildViewRemoved", widget, onChildViewRemoved);
        }

        public void viewModels(com.myworld.ide.struct.op.FieldObject<android.databinding.ObservableList<com.kelin.mvvmlight.base.ViewModel>> viewModels) {
            Invoker.getInstance().bindAttr("viewModels", widget, viewModels);
        }

        public void onChildViewAdded(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewGroupBindingAdapter.OnChildViewAdded> onChildViewAdded) {
            Invoker.getInstance().bindAttr("android:onChildViewAdded", widget, onChildViewAdded);
        }

        public void onAnimationRepeat(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewGroupBindingAdapter.OnAnimationRepeat> onAnimationRepeat) {
            Invoker.getInstance().bindAttr("android:onAnimationRepeat", widget, onAnimationRepeat);
        }
    }

    static class AbsSpinnerBinder extends AdapterViewBinder {
        Widget<AbsSpinner> widget;

        public AbsSpinnerBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public <T> void entries_List_T_(com.myworld.ide.struct.op.FieldObject<java.util.List<T>> entries) {
            Invoker.getInstance().bindAttr("android:entries", widget, entries);
        }

        public <T> void entries(com.myworld.ide.struct.op.FieldObject<T[]> entries) {
            Invoker.getInstance().bindAttr("android:entries", widget, entries);
        }
    }

    static class CompoundButtonBinder extends TextViewBinder {
        Widget<CompoundButton> widget;

        public CompoundButtonBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onCheckedChanged(com.myworld.ide.struct.op.FieldObject<CompoundButton.OnCheckedChangeListener> onCheckedChanged) {
            Invoker.getInstance().bindAttr("android:onCheckedChanged", widget, onCheckedChanged);
        }

        public void checkedAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> checkedAttrChanged) {
            Invoker.getInstance().bindAttr("android:checkedAttrChanged", widget, checkedAttrChanged);
        }

        public void checked(com.myworld.ide.struct.op.FieldObject<Boolean> checked) {
            Invoker.getInstance().bindAttr("android:checked", widget, checked);
        }
    }

    static class AbsListViewBinder extends AdapterViewBinder {
        Widget<AbsListView> widget;

        public AbsListViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onScroll(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AbsListViewBindingAdapter.OnScroll> onScroll) {
            Invoker.getInstance().bindAttr("android:onScroll", widget, onScroll);
        }

        public void onScrollStateChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AbsListViewBindingAdapter.OnScrollStateChanged> onScrollStateChanged) {
            Invoker.getInstance().bindAttr("android:onScrollStateChanged", widget, onScrollStateChanged);
        }
    }

    static class TabHostBinder extends ViewGroupBinder {
        Widget<TabHost> widget;

        public TabHostBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void currentTab(com.myworld.ide.struct.op.FieldObject<Integer> currentTab) {
            Invoker.getInstance().bindAttr("android:currentTab", widget, currentTab);
        }

        public void currentTab_String(com.myworld.ide.struct.op.FieldObject<String> currentTab) {
            Invoker.getInstance().bindAttr("android:currentTab", widget, currentTab);
        }

        public void onTabChanged(com.myworld.ide.struct.op.FieldObject<TabHost.OnTabChangeListener> onTabChanged) {
            Invoker.getInstance().bindAttr("android:onTabChanged", widget, onTabChanged);
        }

        public void currentTabAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> currentTabAttrChanged) {
            Invoker.getInstance().bindAttr("android:currentTabAttrChanged", widget, currentTabAttrChanged);
        }
    }

    static class SearchViewBinder extends ViewGroupBinder {
        Widget<SearchView> widget;

        public SearchViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onQueryTextChange(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange> onQueryTextChange) {
            Invoker.getInstance().bindAttr("android:onQueryTextChange", widget, onQueryTextChange);
        }

        public void onSuggestionClick(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SearchViewBindingAdapter.OnSuggestionClick> onSuggestionClick) {
            Invoker.getInstance().bindAttr("android:onSuggestionClick", widget, onSuggestionClick);
        }

        public void onSuggestionSelect(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SearchViewBindingAdapter.OnSuggestionSelect> onSuggestionSelect) {
            Invoker.getInstance().bindAttr("android:onSuggestionSelect", widget, onSuggestionSelect);
        }

        public void onQueryTextSubmit(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SearchViewBindingAdapter.OnQueryTextSubmit> onQueryTextSubmit) {
            Invoker.getInstance().bindAttr("android:onQueryTextSubmit", widget, onQueryTextSubmit);
        }
    }

    static class ViewBinder extends Binder {
        Widget<View> widget;

        public ViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onLayoutChange(com.myworld.ide.struct.op.FieldObject<View.OnLayoutChangeListener> onLayoutChange) {
            Invoker.getInstance().bindAttr("android:onLayoutChange", widget, onLayoutChange);
        }

        public void clickCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand> clickCommand) {
            Invoker.getInstance().bindAttr("clickCommand", widget, clickCommand);
        }

        public void background(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> background) {
            Invoker.getInstance().bindAttr("android:background", widget, background);
        }

        public void longClickable(com.myworld.ide.struct.op.FieldObject<Boolean> longClickable) {
            Invoker.getInstance().bindAttr("android:longClickable", widget, longClickable);
        }

        public void requiresFadingEdge(com.myworld.ide.struct.op.FieldObject<Integer> requiresFadingEdge) {
            Invoker.getInstance().bindAttr("android:requiresFadingEdge", widget, requiresFadingEdge);
        }

        public void onClick(com.myworld.ide.struct.op.FieldObject<View.OnClickListener> onClick) {
            Invoker.getInstance().bindAttr("android:onClick", widget, onClick);
        }

        public void requestFocus(com.myworld.ide.struct.op.FieldObject<Boolean> requestFocus) {
            Invoker.getInstance().bindAttr("requestFocus", widget, requestFocus);
        }

        public void onTouchCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ResponseCommand<android.view.MotionEvent, Boolean>> onTouchCommand) {
            Invoker.getInstance().bindAttr("onTouchCommand", widget, onTouchCommand);
        }

        public void paddingBottom(com.myworld.ide.struct.op.FieldObject<Float> paddingBottom) {
            Invoker.getInstance().bindAttr("android:paddingBottom", widget, paddingBottom);
        }

        public void paddingLeft(com.myworld.ide.struct.op.FieldObject<Float> paddingLeft) {
            Invoker.getInstance().bindAttr("android:paddingLeft", widget, paddingLeft);
        }

        public void paddingTop(com.myworld.ide.struct.op.FieldObject<Float> paddingTop) {
            Invoker.getInstance().bindAttr("android:paddingTop", widget, paddingTop);
        }

        public void onViewDetachedFromWindow(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewBindingAdapter.OnViewDetachedFromWindow> onViewDetachedFromWindow) {
            Invoker.getInstance().bindAttr("android:onViewDetachedFromWindow", widget, onViewDetachedFromWindow);
        }

        public void paddingRight(com.myworld.ide.struct.op.FieldObject<Float> paddingRight) {
            Invoker.getInstance().bindAttr("android:paddingRight", widget, paddingRight);
        }

        public void onClickListener(com.myworld.ide.struct.op.FieldObject<View.OnClickListener> onClickListener) {
            Invoker.getInstance().bindAttr("android:onClickListener", widget, onClickListener);
        }

        public void onFocusChangeCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Boolean>> onFocusChangeCommand) {
            Invoker.getInstance().bindAttr("onFocusChangeCommand", widget, onFocusChangeCommand);
        }

        public void onLongClickListener(com.myworld.ide.struct.op.FieldObject<View.OnLongClickListener> onLongClickListener) {
            Invoker.getInstance().bindAttr("android:onLongClickListener", widget, onLongClickListener);
        }

        public void padding(com.myworld.ide.struct.op.FieldObject<Float> padding) {
            Invoker.getInstance().bindAttr("android:padding", widget, padding);
        }

        public void onLongClick(com.myworld.ide.struct.op.FieldObject<View.OnLongClickListener> onLongClick) {
            Invoker.getInstance().bindAttr("android:onLongClick", widget, onLongClick);
        }

        public void clickable(com.myworld.ide.struct.op.FieldObject<Boolean> clickable) {
            Invoker.getInstance().bindAttr("android:clickable", widget, clickable);
        }

        public void paddingStart(com.myworld.ide.struct.op.FieldObject<Float> paddingStart) {
            Invoker.getInstance().bindAttr("android:paddingStart", widget, paddingStart);
        }

        public void onViewAttachedToWindow(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.ViewBindingAdapter.OnViewAttachedToWindow> onViewAttachedToWindow) {
            Invoker.getInstance().bindAttr("android:onViewAttachedToWindow", widget, onViewAttachedToWindow);
        }

        public void paddingEnd(com.myworld.ide.struct.op.FieldObject<Float> paddingEnd) {
            Invoker.getInstance().bindAttr("android:paddingEnd", widget, paddingEnd);
        }
    }

    static class ScrollViewBinder extends ViewGroupBinder {
        Widget<ScrollView> widget;

        public ScrollViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onScrollChangeCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.scrollview.ViewBindingAdapter.ScrollDataWrapper>> onScrollChangeCommand) {
            Invoker.getInstance().bindAttr("onScrollChangeCommand", widget, onScrollChangeCommand);
        }
    }

    static class DatePickerBinder extends ViewGroupBinder {
        Widget<DatePicker> widget;

        public DatePickerBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void day(com.myworld.ide.struct.op.FieldObject<Integer> day) {
            Invoker.getInstance().bindAttr("android:day", widget, day);
        }

        public void year(com.myworld.ide.struct.op.FieldObject<Integer> year) {
            Invoker.getInstance().bindAttr("android:year", widget, year);
        }

        public void yearAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> yearAttrChanged) {
            Invoker.getInstance().bindAttr("android:yearAttrChanged", widget, yearAttrChanged);
        }

        public void dayAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> dayAttrChanged) {
            Invoker.getInstance().bindAttr("android:dayAttrChanged", widget, dayAttrChanged);
        }

        public void onDateChanged(com.myworld.ide.struct.op.FieldObject<DatePicker.OnDateChangedListener> onDateChanged) {
            Invoker.getInstance().bindAttr("android:onDateChanged", widget, onDateChanged);
        }

        public void month(com.myworld.ide.struct.op.FieldObject<Integer> month) {
            Invoker.getInstance().bindAttr("android:month", widget, month);
        }

        public void monthAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> monthAttrChanged) {
            Invoker.getInstance().bindAttr("android:monthAttrChanged", widget, monthAttrChanged);
        }
    }

    static class SwitchCompatBinder extends CompoundButtonBinder {
        Widget<SwitchCompat> widget;

        public SwitchCompatBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void switchTextAppearance(com.myworld.ide.struct.op.FieldObject<Integer> switchTextAppearance) {
            Invoker.getInstance().bindAttr("android:switchTextAppearance", widget, switchTextAppearance);
        }
    }

    static class SwitchBinder extends CompoundButtonBinder {
        Widget<Switch> widget;

        public SwitchBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void switchTextAppearance(com.myworld.ide.struct.op.FieldObject<Integer> switchTextAppearance) {
            Invoker.getInstance().bindAttr("android:switchTextAppearance", widget, switchTextAppearance);
        }
    }

    static class CardViewBinder extends ViewGroupBinder {
        Widget<android.support.v7.widget.CardView> widget;

        public CardViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void contentPaddingBottom(com.myworld.ide.struct.op.FieldObject<Integer> contentPaddingBottom) {
            Invoker.getInstance().bindAttr("contentPaddingBottom", widget, contentPaddingBottom);
        }

        public void contentPaddingLeft(com.myworld.ide.struct.op.FieldObject<Integer> contentPaddingLeft) {
            Invoker.getInstance().bindAttr("contentPaddingLeft", widget, contentPaddingLeft);
        }

        public void contentPaddingTop(com.myworld.ide.struct.op.FieldObject<Integer> contentPaddingTop) {
            Invoker.getInstance().bindAttr("contentPaddingTop", widget, contentPaddingTop);
        }

        public void contentPadding(com.myworld.ide.struct.op.FieldObject<Integer> contentPadding) {
            Invoker.getInstance().bindAttr("contentPadding", widget, contentPadding);
        }

        public void contentPaddingRight(com.myworld.ide.struct.op.FieldObject<Integer> contentPaddingRight) {
            Invoker.getInstance().bindAttr("contentPaddingRight", widget, contentPaddingRight);
        }
    }

    static class CalendarViewBinder extends ViewGroupBinder {
        Widget<CalendarView> widget;

        public CalendarViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void dateAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> dateAttrChanged) {
            Invoker.getInstance().bindAttr("android:dateAttrChanged", widget, dateAttrChanged);
        }

        public void date(com.myworld.ide.struct.op.FieldObject<Long> date) {
            Invoker.getInstance().bindAttr("android:date", widget, date);
        }

        public void onSelectedDayChange(com.myworld.ide.struct.op.FieldObject<CalendarView.OnDateChangeListener> onSelectedDayChange) {
            Invoker.getInstance().bindAttr("android:onSelectedDayChange", widget, onSelectedDayChange);
        }
    }

    static class NumberPickerBinder extends ViewGroupBinder {
        Widget<NumberPicker> widget;

        public NumberPickerBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onValueChange(com.myworld.ide.struct.op.FieldObject<NumberPicker.OnValueChangeListener> onValueChange) {
            Invoker.getInstance().bindAttr("android:onValueChange", widget, onValueChange);
        }

        public void valueAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> valueAttrChanged) {
            Invoker.getInstance().bindAttr("android:valueAttrChanged", widget, valueAttrChanged);
        }

        public void value(com.myworld.ide.struct.op.FieldObject<Integer> value) {
            Invoker.getInstance().bindAttr("android:value", widget, value);
        }
    }
    static class ViewPagerBinder extends ViewGroupBinder {
        Widget<ViewPager> widget;

        public ViewPagerBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onPageScrollStateChangedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onPageScrollStateChangedCommand) {
            Invoker.getInstance().bindAttr("onPageScrollStateChangedCommand", widget, onPageScrollStateChangedCommand);
        }

        public void onPageScrolledCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.viewpager.ViewBindingAdapter.ViewPagerDataWrapper>> onPageScrolledCommand) {
            Invoker.getInstance().bindAttr("onPageScrolledCommand", widget, onPageScrolledCommand);
        }

        public <T> void pageTitles(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.BindingViewPagerAdapter.PageTitles<T>> pageTitles) {
            Invoker.getInstance().bindAttr("pageTitles", widget, pageTitles);
        }

        public <T> void itemView(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.ItemViewArg<T>> itemView) {
            Invoker.getInstance().bindAttr("itemView", widget, itemView);
        }

        public void onPageSelectedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onPageSelectedCommand) {
            Invoker.getInstance().bindAttr("onPageSelectedCommand", widget, onPageSelectedCommand);
        }

        public <T> void items(com.myworld.ide.struct.op.FieldObject<java.util.List<T>> items) {
            Invoker.getInstance().bindAttr("items", widget, items);
        }

        public void adapter(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.factories.BindingViewPagerAdapterFactory> adapter) {
            Invoker.getInstance().bindAttr("adapter", widget, adapter);
        }
    }

    static class SeekBarBinder extends ViewBinder {
        Widget<SeekBar> widget;

        public SeekBarBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onStartTrackingTouch(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SeekBarBindingAdapter.OnStartTrackingTouch> onStartTrackingTouch) {
            Invoker.getInstance().bindAttr("android:onStartTrackingTouch", widget, onStartTrackingTouch);
        }

        public void onStopTrackingTouch(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch> onStopTrackingTouch) {
            Invoker.getInstance().bindAttr("android:onStopTrackingTouch", widget, onStopTrackingTouch);
        }

        public void onProgressChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged> onProgressChanged) {
            Invoker.getInstance().bindAttr("android:onProgressChanged", widget, onProgressChanged);
        }

        public void progress(com.myworld.ide.struct.op.FieldObject<Integer> progress) {
            Invoker.getInstance().bindAttr("android:progress", widget, progress);
        }

        public void progressAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> progressAttrChanged) {
            Invoker.getInstance().bindAttr("android:progressAttrChanged", widget, progressAttrChanged);
        }
    }

    static class TableLayoutBinder extends ViewGroupBinder {
        Widget<TableLayout> widget;

        public TableLayoutBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void collapseColumns(com.myworld.ide.struct.op.FieldObject<CharSequence> collapseColumns) {
            Invoker.getInstance().bindAttr("android:collapseColumns", widget, collapseColumns);
        }

        public void shrinkColumns(com.myworld.ide.struct.op.FieldObject<CharSequence> shrinkColumns) {
            Invoker.getInstance().bindAttr("android:shrinkColumns", widget, shrinkColumns);
        }

        public void stretchColumns(com.myworld.ide.struct.op.FieldObject<CharSequence> stretchColumns) {
            Invoker.getInstance().bindAttr("android:stretchColumns", widget, stretchColumns);
        }
    }

    static class EditTextBinder extends TextViewBinder {
        Widget<EditText> widget;

        public EditTextBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void requestFocus(com.myworld.ide.struct.op.FieldObject<Boolean> requestFocus) {
            Invoker.getInstance().bindAttr("requestFocus", widget, requestFocus);
        }

        public void afterTextChangedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<String>> afterTextChangedCommand) {
            Invoker.getInstance().bindAttr("afterTextChangedCommand", widget, afterTextChangedCommand);
        }

        public void beforeTextChangedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.edittext.ViewBindingAdapter.TextChangeDataWrapper>> beforeTextChangedCommand) {
            Invoker.getInstance().bindAttr("beforeTextChangedCommand", widget, beforeTextChangedCommand);
        }

        public void onTextChangedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.edittext.ViewBindingAdapter.TextChangeDataWrapper>> onTextChangedCommand) {
            Invoker.getInstance().bindAttr("onTextChangedCommand", widget, onTextChangedCommand);
        }
    }

    static class AutoCompleteTextViewBinder extends EditTextBinder {
        Widget<AutoCompleteTextView> widget;

        public AutoCompleteTextViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void fixText(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AutoCompleteTextViewBindingAdapter.FixText> fixText) {
            Invoker.getInstance().bindAttr("android:fixText", widget, fixText);
        }

        public void onNothingSelected(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected> onNothingSelected) {
            Invoker.getInstance().bindAttr("android:onNothingSelected", widget, onNothingSelected);
        }

        public void onItemSelected(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected> onItemSelected) {
            Invoker.getInstance().bindAttr("android:onItemSelected", widget, onItemSelected);
        }

        public void isValid(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AutoCompleteTextViewBindingAdapter.IsValid> isValid) {
            Invoker.getInstance().bindAttr("android:isValid", widget, isValid);
        }
    }

    static class RadioGroupBinder extends ViewGroupBinder {
        Widget<RadioGroup> widget;

        public RadioGroupBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void checkedButton(com.myworld.ide.struct.op.FieldObject<Integer> checkedButton) {
            Invoker.getInstance().bindAttr("android:checkedButton", widget, checkedButton);
        }

        public void onCheckedChanged(com.myworld.ide.struct.op.FieldObject<RadioGroup.OnCheckedChangeListener> onCheckedChanged) {
            Invoker.getInstance().bindAttr("android:onCheckedChanged", widget, onCheckedChanged);
        }

        public void checkedButtonAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> checkedButtonAttrChanged) {
            Invoker.getInstance().bindAttr("android:checkedButtonAttrChanged", widget, checkedButtonAttrChanged);
        }
    }

    static class AdapterViewBinder extends ViewGroupBinder {
        Widget<AdapterView> widget;

        public AdapterViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onNothingSelected(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected> onNothingSelected) {
            Invoker.getInstance().bindAttr("android:onNothingSelected", widget, onNothingSelected);
        }

        public <T> void itemView(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.ItemViewArg<T>> itemView) {
            Invoker.getInstance().bindAttr("itemView", widget, itemView);
        }

        public <T> void items(com.myworld.ide.struct.op.FieldObject<java.util.List<T>> items) {
            Invoker.getInstance().bindAttr("items", widget, items);
        }

        public void selectedItemPositionAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> selectedItemPositionAttrChanged) {
            Invoker.getInstance().bindAttr("android:selectedItemPositionAttrChanged", widget, selectedItemPositionAttrChanged);
        }

        public void adapter(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.factories.BindingAdapterViewFactory> adapter) {
            Invoker.getInstance().bindAttr("adapter", widget, adapter);
        }

        public void dropDownItemView(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.ItemView> dropDownItemView) {
            Invoker.getInstance().bindAttr("dropDownItemView", widget, dropDownItemView);
        }

        public void onItemSelected(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected> onItemSelected) {
            Invoker.getInstance().bindAttr("android:onItemSelected", widget, onItemSelected);
        }

        public <T> void itemIsEnabled(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.BindingListViewAdapter.ItemIsEnabled<T>> itemIsEnabled) {
            Invoker.getInstance().bindAttr("itemIsEnabled", widget, itemIsEnabled);
        }

        public void selectedItemPosition(com.myworld.ide.struct.op.FieldObject<Integer> selectedItemPosition) {
            Invoker.getInstance().bindAttr("android:selectedItemPosition", widget, selectedItemPosition);
        }

        public <T> void itemIds(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.BindingListViewAdapter.ItemIds<T>> itemIds) {
            Invoker.getInstance().bindAttr("itemIds", widget, itemIds);
        }
    }

    static class TimePickerBinder extends ViewGroupBinder {
        Widget<TimePicker> widget;

        public TimePickerBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void minute(com.myworld.ide.struct.op.FieldObject<Integer> minute) {
            Invoker.getInstance().bindAttr("android:minute", widget, minute);
        }

        public void hourAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> hourAttrChanged) {
            Invoker.getInstance().bindAttr("android:hourAttrChanged", widget, hourAttrChanged);
        }

        public void onTimeChanged(com.myworld.ide.struct.op.FieldObject<TimePicker.OnTimeChangedListener> onTimeChanged) {
            Invoker.getInstance().bindAttr("android:onTimeChanged", widget, onTimeChanged);
        }

        public void minuteAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> minuteAttrChanged) {
            Invoker.getInstance().bindAttr("android:minuteAttrChanged", widget, minuteAttrChanged);
        }

        public void hour(com.myworld.ide.struct.op.FieldObject<Integer> hour) {
            Invoker.getInstance().bindAttr("android:hour", widget, hour);
        }
    }

    static class RatingBarBinder extends ViewBinder {
        Widget<RatingBar> widget;

        public RatingBarBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void rating(com.myworld.ide.struct.op.FieldObject<Float> rating) {
            Invoker.getInstance().bindAttr("android:rating", widget, rating);
        }

        public void ratingAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> ratingAttrChanged) {
            Invoker.getInstance().bindAttr("android:ratingAttrChanged", widget, ratingAttrChanged);
        }

        public void onRatingChanged(com.myworld.ide.struct.op.FieldObject<RatingBar.OnRatingBarChangeListener> onRatingChanged) {
            Invoker.getInstance().bindAttr("android:onRatingChanged", widget, onRatingChanged);
        }
    }

    static class SimpleDraweeViewBinder extends ImageViewBinder {
        Widget<com.facebook.drawee.view.SimpleDraweeView> widget;

        public SimpleDraweeViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void uri(com.myworld.ide.struct.op.FieldObject<String> uri) {
            Invoker.getInstance().bindAttr("uri", widget, uri);
        }
    }

    static class ImageViewBinder extends ViewBinder {
        Widget<ImageView> widget;

        public ImageViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void src(com.myworld.ide.struct.op.FieldObject<String> src) {
            Invoker.getInstance().bindAttr("android:src", widget, src);
        }

        public void src_Uri(com.myworld.ide.struct.op.FieldObject<android.net.Uri> src) {
            Invoker.getInstance().bindAttr("android:src", widget, src);
        }

        public void uri(com.myworld.ide.struct.op.FieldObject<String> uri) {
            Invoker.getInstance().bindAttr("uri", widget, uri);
        }

        public void request_height(com.myworld.ide.struct.op.FieldObject<Integer> request_height) {
            Invoker.getInstance().bindAttr("request_height", widget, request_height);
        }

        public void placeholderImageRes(com.myworld.ide.struct.op.FieldObject<Integer> placeholderImageRes) {
            Invoker.getInstance().bindAttr("placeholderImageRes", widget, placeholderImageRes);
        }

        public void request_width(com.myworld.ide.struct.op.FieldObject<Integer> request_width) {
            Invoker.getInstance().bindAttr("request_width", widget, request_width);
        }

        public void onFailureCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>>> onFailureCommand) {
            Invoker.getInstance().bindAttr("onFailureCommand", widget, onFailureCommand);
        }

        public void onSuccessCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<android.graphics.Bitmap>> onSuccessCommand) {
            Invoker.getInstance().bindAttr("onSuccessCommand", widget, onSuccessCommand);
        }

        public void src_Drawable(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> src) {
            Invoker.getInstance().bindAttr("android:src", widget, src);
        }
    }

    static class WebViewBinder extends ViewGroupBinder {
        Widget<WebView> widget;

        public WebViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void render(com.myworld.ide.struct.op.FieldObject<String> render) {
            Invoker.getInstance().bindAttr("render", widget, render);
        }
    }

    static class SwipeRefreshLayoutBinder extends ViewGroupBinder {
        Widget<SwipeRefreshLayout> widget;

        public SwipeRefreshLayoutBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onRefreshCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand> onRefreshCommand) {
            Invoker.getInstance().bindAttr("onRefreshCommand", widget, onRefreshCommand);
        }
    }

    static class TextViewBinder extends ViewBinder {
        Widget<TextView> widget;

        public TextViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void autoText(com.myworld.ide.struct.op.FieldObject<Boolean> autoText) {
            Invoker.getInstance().bindAttr("android:autoText", widget, autoText);
        }

        public void drawableLeft(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> drawableLeft) {
            Invoker.getInstance().bindAttr("android:drawableLeft", widget, drawableLeft);
        }

        public void numeric(com.myworld.ide.struct.op.FieldObject<Integer> numeric) {
            Invoker.getInstance().bindAttr("android:numeric", widget, numeric);
        }

        public void lineSpacingExtra(com.myworld.ide.struct.op.FieldObject<Float> lineSpacingExtra) {
            Invoker.getInstance().bindAttr("android:lineSpacingExtra", widget, lineSpacingExtra);
        }

        public void textAttrChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.InverseBindingListener> textAttrChanged) {
            Invoker.getInstance().bindAttr("android:textAttrChanged", widget, textAttrChanged);
        }

        public void capitalize(com.myworld.ide.struct.op.FieldObject<android.text.method.TextKeyListener.Capitalize> capitalize) {
            Invoker.getInstance().bindAttr("android:capitalize", widget, capitalize);
        }

        public void imeActionId(com.myworld.ide.struct.op.FieldObject<Integer> imeActionId) {
            Invoker.getInstance().bindAttr("android:imeActionId", widget, imeActionId);
        }

        public void textSize(com.myworld.ide.struct.op.FieldObject<Float> textSize) {
            Invoker.getInstance().bindAttr("android:textSize", widget, textSize);
        }

        public void drawableTop(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> drawableTop) {
            Invoker.getInstance().bindAttr("android:drawableTop", widget, drawableTop);
        }

        public void shadowColor(com.myworld.ide.struct.op.FieldObject<Integer> shadowColor) {
            Invoker.getInstance().bindAttr("android:shadowColor", widget, shadowColor);
        }

        public void drawableBottom(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> drawableBottom) {
            Invoker.getInstance().bindAttr("android:drawableBottom", widget, drawableBottom);
        }

        public void drawableStart(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> drawableStart) {
            Invoker.getInstance().bindAttr("android:drawableStart", widget, drawableStart);
        }

        public void lineSpacingMultiplier(com.myworld.ide.struct.op.FieldObject<Float> lineSpacingMultiplier) {
            Invoker.getInstance().bindAttr("android:lineSpacingMultiplier", widget, lineSpacingMultiplier);
        }

        public void password(com.myworld.ide.struct.op.FieldObject<Boolean> password) {
            Invoker.getInstance().bindAttr("android:password", widget, password);
        }

        public void digits(com.myworld.ide.struct.op.FieldObject<CharSequence> digits) {
            Invoker.getInstance().bindAttr("android:digits", widget, digits);
        }

        public void drawableRight(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> drawableRight) {
            Invoker.getInstance().bindAttr("android:drawableRight", widget, drawableRight);
        }

        public void text(com.myworld.ide.struct.op.FieldObject<? extends CharSequence> text) {
            Invoker.getInstance().bindAttr("android:text", widget, text);
        }

        public void maxLength(com.myworld.ide.struct.op.FieldObject<Integer> maxLength) {
            Invoker.getInstance().bindAttr("android:maxLength", widget, maxLength);
        }

        public void imeActionLabel(com.myworld.ide.struct.op.FieldObject<CharSequence> imeActionLabel) {
            Invoker.getInstance().bindAttr("android:imeActionLabel", widget, imeActionLabel);
        }

        public void onTextChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.TextViewBindingAdapter.OnTextChanged> onTextChanged) {
            Invoker.getInstance().bindAttr("android:onTextChanged", widget, onTextChanged);
        }

        public void phoneNumber(com.myworld.ide.struct.op.FieldObject<Boolean> phoneNumber) {
            Invoker.getInstance().bindAttr("android:phoneNumber", widget, phoneNumber);
        }

        public void drawableEnd(com.myworld.ide.struct.op.FieldObject<android.graphics.drawable.Drawable> drawableEnd) {
            Invoker.getInstance().bindAttr("android:drawableEnd", widget, drawableEnd);
        }

        public void shadowRadius(com.myworld.ide.struct.op.FieldObject<Float> shadowRadius) {
            Invoker.getInstance().bindAttr("android:shadowRadius", widget, shadowRadius);
        }

        public void shadowDx(com.myworld.ide.struct.op.FieldObject<Float> shadowDx) {
            Invoker.getInstance().bindAttr("android:shadowDx", widget, shadowDx);
        }

        public void afterTextChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged> afterTextChanged) {
            Invoker.getInstance().bindAttr("android:afterTextChanged", widget, afterTextChanged);
        }

        public void bufferType(com.myworld.ide.struct.op.FieldObject<TextView.BufferType> bufferType) {
            Invoker.getInstance().bindAttr("android:bufferType", widget, bufferType);
        }

        public void shadowDy(com.myworld.ide.struct.op.FieldObject<Float> shadowDy) {
            Invoker.getInstance().bindAttr("android:shadowDy", widget, shadowDy);
        }

        public void inputMethod(com.myworld.ide.struct.op.FieldObject<CharSequence> inputMethod) {
            Invoker.getInstance().bindAttr("android:inputMethod", widget, inputMethod);
        }

        public void beforeTextChanged(com.myworld.ide.struct.op.FieldObject<android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged> beforeTextChanged) {
            Invoker.getInstance().bindAttr("android:beforeTextChanged", widget, beforeTextChanged);
        }
    }

    static class NestedScrollViewBinder extends ViewGroupBinder {
        Widget<NestedScrollView> widget;

        public NestedScrollViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onScrollChangeCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.scrollview.ViewBindingAdapter.NestScrollDataWrapper>> onScrollChangeCommand) {
            Invoker.getInstance().bindAttr("onScrollChangeCommand", widget, onScrollChangeCommand);
        }
    }

    static class ListViewBinder extends AbsListViewBinder {
        Widget<ListView> widget;

        public ListViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public void onItemClickCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onItemClickCommand) {
            Invoker.getInstance().bindAttr("onItemClickCommand", widget, onItemClickCommand);
        }

        public void onScrollStateChangedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onScrollStateChangedCommand) {
            Invoker.getInstance().bindAttr("onScrollStateChangedCommand", widget, onScrollStateChangedCommand);
        }

        public void onLoadMoreCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onLoadMoreCommand) {
            Invoker.getInstance().bindAttr("onLoadMoreCommand", widget, onLoadMoreCommand);
        }

        public void onScrollChangeCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.listview.ViewBindingAdapter.ListViewScrollDataWrapper>> onScrollChangeCommand) {
            Invoker.getInstance().bindAttr("onScrollChangeCommand", widget, onScrollChangeCommand);
        }
    }

    static class RecyclerViewBinder extends ViewGroupBinder {
        Widget<android.support.v7.widget.RecyclerView> widget;

        public RecyclerViewBinder(Widget widget) {
            super(widget);
            this.widget = widget;
        }

        public <T> void itemView(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.ItemViewArg<T>> itemView) {
            Invoker.getInstance().bindAttr("itemView", widget, itemView);
        }

        public void layoutManager(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.LayoutManagers.LayoutManagerFactory> layoutManager) {
            Invoker.getInstance().bindAttr("layoutManager", widget, layoutManager);
        }

        public void onLoadMoreCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onLoadMoreCommand) {
            Invoker.getInstance().bindAttr("onLoadMoreCommand", widget, onLoadMoreCommand);
        }

        public <T> void items(com.myworld.ide.struct.op.FieldObject<java.util.List<T>> items) {
            Invoker.getInstance().bindAttr("items", widget, items);
        }

        public <T> void itemIds(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.BindingRecyclerViewAdapter.ItemIds<T>> itemIds) {
            Invoker.getInstance().bindAttr("itemIds", widget, itemIds);
        }

        public void onScrollStateChangedCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<Integer>> onScrollStateChangedCommand) {
            Invoker.getInstance().bindAttr("onScrollStateChangedCommand", widget, onScrollStateChangedCommand);
        }

        public void onScrollChangeCommand(com.myworld.ide.struct.op.FieldObject<com.kelin.mvvmlight.command.ReplyCommand<com.kelin.mvvmlight.bindingadapter.recyclerview.ViewBindingAdapter.ScrollDataWrapper>> onScrollChangeCommand) {
            Invoker.getInstance().bindAttr("onScrollChangeCommand", widget, onScrollChangeCommand);
        }

        public void adapter(com.myworld.ide.struct.op.FieldObject<me.tatarka.bindingcollectionadapter.factories.BindingRecyclerViewAdapterFactory> adapter) {
            Invoker.getInstance().bindAttr("adapter", widget, adapter);
        }
    }
}
