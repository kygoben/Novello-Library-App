package com.yn_1.novello_app.reading;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.*;

/**
 * Reading View <br>
 * For displaying data via the UI. Is the fragment of the screen.
 *
 * @author Roba Abbajabal
 */
public class ReadingFragment extends Fragment implements ReadingContract.View {

    private WebView webView;

    // Presenter accessible from View
    private ReadingContract.Presenter presenter;

    /**
     * Creates a new fragment instance, using specific arguments to be added to the bundle.
     *
     * @return A new instance of fragment ReadingFragment.
     */
    public static ReadingFragment newInstance() {
        ReadingFragment fragment = new ReadingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Params
        int bookID = ReadingFragmentArgs.fromBundle(getArguments()).getBookID();
        String readingLink = ReadingFragmentArgs.fromBundle(getArguments()).getReadingLink();

        // Create Presenter
        presenter = new ReadingPresenter(new ReadingModel(bookID, readingLink), this);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reading, container, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView = view.findViewById(R.id.readingView);
        webView.loadUrl(ReadingFragmentArgs.fromBundle(getArguments()).getReadingLink());
        presenter.onPageLoad(((NavBarActivity)getActivity()).getUser());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                webView.evaluateJavascript("javascript:"
                        + "document.body.style.margin = \"5px\";"
                        + "document.body.style.padding = \"5px\";", null);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop() {
        super.onStop();
        presenter.onPageLoad(((NavBarActivity)getActivity()).getUser());
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getProgress() {
        return webView.getScrollY() - webView.getTop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getProgressPercentage() {
        return (double) getProgress() / webView.getContentHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jumpToProgress(int progress) {
        webView.setScrollY(progress + webView.getTop());
    }
}