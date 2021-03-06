package cn.buding.coupon.main;

import cn.buding.coupon.base.Logger;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;
import cn.buding.coupon.views.BrandCouponsView;
import cn.buding.coupon.views.CouponDetailsSliderView;
import cn.buding.coupon.views.CouponView;

import com.jayway.android.robotium.solo.Solo;


import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

@SuppressWarnings("rawtypes")
public class MainTest extends ActivityInstrumentationTestCase2 {

	public static Solo solo;
	public static Class<?> LAUNCHER_ACTIVITY_CLASS = null;
	private RobotiumTools robotiumTools= null;
	private Instrumentation instrumentation = null;
	static{
		try {
			LAUNCHER_ACTIVITY_CLASS = Class.forName(StaticField.Activity.LAUNCHER_ACTIVITY);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.d(e.getMessage());
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public MainTest() {
		// TODO Auto-generated constructor stub
		super(StaticField.COUPON_PACKAGE, LAUNCHER_ACTIVITY_CLASS);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		instrumentation = getInstrumentation();
		solo = new Solo(instrumentation, getActivity());
		robotiumTools = RobotiumTools.getInstance();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		solo.finishOpenedActivities();
	}
	
//	/**
//	 * 切换tab页面
//	 * @throws Exception
//	 */
//	public void testSwitchTab() throws Exception{
//		TestCaseSwitchTabView testcase1 = new TestCaseSwitchTabView(solo, robotiumTools);
//		testcase1.testSwitchTabToSetting();
//		testcase1.testSwitchTabToMore();
//		testcase1.testSwitchTabToNearBy();
//	}
//	
//	
//	/**
//	 * 切换城市
//	 * @throws Exception
//	 */
//	public void testChangeCity() throws Exception{
//		TestCaseChangeCity changeCity = new TestCaseChangeCity(solo, main);
//		changeCity.changeCity("上海");
//		changeCity.changeCity(3);
//		changeCity.changeSelectedCity();
//	}
	
	public void test() throws Exception{
		CouponView couponView = new CouponView(robotiumTools);
		couponView.waitForActivity();
		couponView.clickBrand("特价电影票");
		BrandCouponsView brandCouponsView= new BrandCouponsView(robotiumTools);
		brandCouponsView.waitForActivity();
		brandCouponsView.clickOnList(1);
		CouponDetailsSliderView couponDetailsSliderView = new CouponDetailsSliderView(robotiumTools,solo);
		couponDetailsSliderView.waitForActivity();
		couponDetailsSliderView.clickFavorBtn();
		couponDetailsSliderView.clickRightPageBtn();
		couponDetailsSliderView.clickFavorBtn();
		robotiumTools.goBack();
		robotiumTools.sleep();
	}
	
}
