package totalcross.sample.components;

import totalcross.sample.util.Colors;
import totalcross.sample.util.Images;
import totalcross.ui.Container;
import totalcross.ui.ListContainer;
import totalcross.ui.ScrollContainer;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class ListContainerSample extends Container {

	private ScrollContainer sc;
	private ListContainer lcSocialNetworks = new ListContainer();

	private int SC_GAP = fmH/2;

	@Override
	public void initUI() {

		try {
			super.initUI();
			
			sc = new ScrollContainer(false, true);
			sc.setInsets(SC_GAP, SC_GAP, SC_GAP, SC_GAP);
			add(sc,LEFT,TOP,FILL,FILL);

			lcSocialNetworks.getFlick().longestFlick = 15;
			lcSocialNetworks.setBackColor(Colors.BACKGROUND);
			sc.add(lcSocialNetworks, LEFT, TOP, FILL, FILL);
			
			ListContainer.Item facebook = new ListContainer.Item(getLayout(new Image("images/fb_icon_40.png")));
			facebook.items = new String[] { "  ", " Name", "   Facebook", "", "" };

			ListContainer.Item twitter = new ListContainer.Item(getLayout(new Image("images/tt_icon_40.png")));
			twitter.items = new String[] { "  ", " Name", "   Twitter", "", "" };

			ListContainer.Item instagram = new ListContainer.Item(getLayout(new Image("images/insta_icon_40.png")));
			instagram.items = new String[] { "  ", " Name", "   Instagram", "", "" };

			ListContainer.Item tumblr = new ListContainer.Item(getLayout(new Image("images/tumblr_icon_40.png")));
			tumblr.items = new String[] { "  ", " Name", "   Tumblr", "", "" };

			ListContainer.Item googlePlus = new ListContainer.Item(getLayout(new Image("images/gmail_icon_40.png")));
			googlePlus.items = new String[] { "  ", " Name", "   Google +", "", "" };

			Container socialNetworks[] = new Container[5];
			socialNetworks[0] = facebook;
			socialNetworks[1] = twitter;
			socialNetworks[2] = instagram;
			socialNetworks[3] = tumblr;
			socialNetworks[4] = googlePlus;

			lcSocialNetworks.addContainers(socialNetworks);
			lcSocialNetworks.autoScroll = true;
			lcSocialNetworks.requestFocus();

		} catch (Exception ee) {
			MessageBox.showException(ee, true);
		}
	}

	private ListContainer.Layout getLayout(Image leftImage) {

		ListContainer.Layout layout = lcSocialNetworks.getLayout(5, 2);

		try {

			layout.insets.set(50, 10, 50, 10);
			layout.leftImageEnlargeIfSmaller = false;
			layout.defaultLeftImage = leftImage;
			layout.defaultRightImage = Images.aplyColor(new Image("images/thumb-up.png"), Colors.GRAY)
					.hwScaledFixedAspectRatio(fmH, true);
			layout.defaultRightImage2 = Images.aplyColor(new Image("images/thumb-up.png"), Colors.BLUE)
					.hwScaledFixedAspectRatio(fmH, true);
			layout.controlGap = 30;
			layout.lineGap = 1;
			layout.boldItems[2] = false;
			layout.fontNames[2] = "Lato Bold";
			layout.defaultItemColors[2] = Color.BLACK;
			layout.relativeFontSizes[1] = -5;
			layout.relativeFontSizes[2] = +2;
			layout.relativeFontSizes[3] = -15;
			layout.positions[3] = RIGHT;
			layout.setup();

		} catch (Exception ee) {
			MessageBox.showException(ee, true);
		}

		return layout;
	}

}
