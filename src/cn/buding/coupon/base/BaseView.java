package cn.buding.coupon.base;

public abstract class BaseView {
    protected static int TIME_DELAY = 1000;
    protected static String TV_TITLE = "tv_title";
    protected RobotiumTools tools;

    public BaseView(RobotiumTools tools) {
	this.tools = tools;
    }

    public abstract void waitForActivity();

    public String getViewTitle() {
	return tools.getTextById(TV_TITLE);
    }
}
