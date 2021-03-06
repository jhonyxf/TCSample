package totalcross.sample.components.ui;

import totalcross.sample.util.Colors;
import totalcross.ui.ButtonMenu;
import totalcross.ui.Container;
import totalcross.ui.Spinner;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.dialog.ProgressBox;
import totalcross.ui.gfx.Color;

public class ProgressBoxSample extends Container {
  private ButtonMenu menu;
  private ProgressBox pb;
  private int count;

  @Override
  public void initUI() {
    try {
      super.initUI();
      String[] items = {"ProgressBox (Android Spinner)", "ProgressBox (iOS Spinner)"};
      pb = new ProgressBox("Alert!", "null", items, true);
      

      menu = new ButtonMenu(items, ButtonMenu.SINGLE_COLUMN);
      menu.borderGap = 130;
      menu.textGap = 40;
      menu.buttonVertGap = 880;
      
      menu.pressedColor = Color.GREEN;
      add(menu, LEFT, TOP, FILL, FILL);

      count = 2;
      
      for (int i = 0; i < items.length; i++)
    	  menu.getButton(i).setBackForeColors(Colors.P_600, Colors.ON_P_600);
      
      
      menu.addPressListener((e) -> {
    	  int sel = menu.getSelectedIndex();
          Spinner.spinnerType = sel == 0 ? Spinner.ANDROID : Spinner.IPHONE;
          
          pb = new ProgressBox("Alert!", "Please wait " + count + " seconds.");
          pb.setBackForeColors(Colors.P_700, Colors.ON_P_700);
          menu.addTimer(1000);
          pb.popup();
      });
      
      menu.addTimerListener((e) -> {
    	  if(count >= 0) {
    		  pb.setText("Please wait " + count + " seconds.");
    		  count--;
    	  } else {
    		  pb.unpop();
    		  count = 2;
    		  menu.removeTimer(e);
    	  }
      });
      
    } catch (Exception ee) {
      MessageBox.showException(ee, true);
    }
  }
}
