package com.ashish.alegria3;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlegriaBody extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_alegria_body);

		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager_body);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}


	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
			if (position == 0){
				return new EventsFragment();
			}
			else if (position == 1) {
				return new ContactUsFragment();
			}
			else {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args); 
			}
			return fragment;
			
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@SuppressLint("DefaultLocale")
		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section2).toUpperCase(l);
			case 1:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_alegria_body_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}
	public static class ContactUsFragment extends Fragment implements OnClickListener{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public ContactUsFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.contact_us_fragment, container, false);
			
			ImageView iv_fb = (ImageView) rootView.findViewById(R.id.iv_facebook);
			
			iv_fb.setOnClickListener(this);
			
			
			
			return rootView;
		}
		@Override
		public void onClick(View v) {
			Intent intent;
			intent = new Intent(this.getActivity(), GridViewActivity.class);
			this.startActivity(intent);
		}
	}
	public static class AboutMeFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public AboutMeFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.about_me_fragment, container, false);
			return rootView;
		}
	}
	public static class EventsFragment extends Fragment implements OnClickListener {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public EventsFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.events_fragment, container, false);
			
			Button bn_mgt1 = (Button) rootView.findViewById(R.id.bn_mgt1);
			Button bn_mgt2 = (Button) rootView.findViewById(R.id.bn_mgt2);
			Button bn_mgt3 = (Button) rootView.findViewById(R.id.bn_mgt3);
			Button bn_mgt4 = (Button) rootView.findViewById(R.id.bn_mgt4);
			Button bn_mgt5 = (Button) rootView.findViewById(R.id.bn_mgt5);
			Button bn_mgt6 = (Button) rootView.findViewById(R.id.bn_mgt6);
			Button bn_mgt7 = (Button) rootView.findViewById(R.id.bn_mgt7);
			Button bn_mgt8 = (Button) rootView.findViewById(R.id.bn_mgt8);
			Button bn_mgt9 = (Button) rootView.findViewById(R.id.bn_mgt9);

			Button bn_fa01 = (Button) rootView.findViewById(R.id.bn_fa01);
			Button bn_fa02 = (Button) rootView.findViewById(R.id.bn_fa02);
			Button bn_fa03 = (Button) rootView.findViewById(R.id.bn_fa03);
			Button bn_fa04 = (Button) rootView.findViewById(R.id.bn_fa04);
			Button bn_fa05 = (Button) rootView.findViewById(R.id.bn_fa05);
			Button bn_fa06 = (Button) rootView.findViewById(R.id.bn_fa06);
			Button bn_fa07 = (Button) rootView.findViewById(R.id.bn_fa07);
			Button bn_fa08 = (Button) rootView.findViewById(R.id.bn_fa08);
			Button bn_fa09 = (Button) rootView.findViewById(R.id.bn_fa09);
			
			
			bn_mgt1.setOnClickListener(this);
			bn_mgt2.setOnClickListener(this);
			bn_mgt3.setOnClickListener(this);
			bn_mgt4.setOnClickListener(this);
			bn_mgt5.setOnClickListener(this);
			bn_mgt6.setOnClickListener(this);
			bn_mgt7.setOnClickListener(this);
			bn_mgt8.setOnClickListener(this);
			bn_mgt9.setOnClickListener(this);

			bn_fa01.setOnClickListener(this);
			bn_fa02.setOnClickListener(this);
			bn_fa03.setOnClickListener(this);
			bn_fa04.setOnClickListener(this);
			bn_fa05.setOnClickListener(this);
			bn_fa06.setOnClickListener(this);
			bn_fa07.setOnClickListener(this);
			bn_fa08.setOnClickListener(this);
			bn_fa09.setOnClickListener(this);

			return rootView;
		}
		@Override
		public void onClick(View v) {
			Intent intent;
			intent = new Intent("com.ashish.alegria3.EVENTACTIVITY");
			intent.putExtra("EventCode", "");

			switch(v.getId()){
			  case R.id.bn_mgt1:
				  System.out.println("Button clicked");
			       break;

			  case R.id.bn_mgt2: intent.putExtra("EventCode", "MGT101"); break; 
			  case R.id.bn_mgt3: intent.putExtra("EventCode", "MGT102"); break;
			  
			  case R.id.bn_fa01: intent.putExtra("EventCode", "FA101"); break; 
			  case R.id.bn_fa02: intent.putExtra("EventCode", "FA102"); break; 
			  case R.id.bn_fa03: intent.putExtra("EventCode", "FA103"); break; 
			  case R.id.bn_fa04: intent.putExtra("EventCode", "FA104"); break; 
			  case R.id.bn_fa05: intent.putExtra("EventCode", "FA105"); break; 
			  case R.id.bn_fa06: intent.putExtra("EventCode", "FA106"); break; 
			  case R.id.bn_fa07: intent.putExtra("EventCode", "FA107"); break; 
			  case R.id.bn_fa08: intent.putExtra("EventCode", "FA108"); break; 
			  case R.id.bn_fa09: intent.putExtra("EventCode", "FA109"); break; 

			 
			  }
		      this.startActivity(intent);


			
		}
	}
	


}
