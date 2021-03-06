package totalcross.sample.components.cards;

import totalcross.sys.Settings;
import totalcross.ui.ScrollContainer;

public class CardsSample extends ScrollContainer {
	private int gap = (int) (Settings.screenDensity * 20);
  public CardsSample() {
    super(false, true);
  }

  public void initUI() {
    setBackColor(0xDCDCDC);
    final int DP_10 = (int) (Settings.screenDensity * 10);
    setInsets(0, 0, DP_10, DP_10);

    add(new CardSearch(), LEFT + gap, TOP, FILL - gap, 60 + DP);
    add(new CardProfile(), LEFT + gap, AFTER + 50, FILL - gap, DP + 240);
    add(new CardWeather(), LEFT + gap, AFTER + 50, FILL - gap, 170 + DP);
  }
}
