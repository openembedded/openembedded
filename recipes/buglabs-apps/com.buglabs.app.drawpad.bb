require bug-app.inc

DESCRIPTION = "Here's a somewhat simple drawing pad for the BUG.\
Take a picture with button one on the BUG (or the camera button) to place the picture on the canvas.  Then draw on the canvas.  You can draw free-form lines, straight lines, circles, or a couple of pre-fab phrases.  You can choose a color.  The erase button clears the whole thing.\
Press button 2 on the BUG to save your creation as a .bmp file in your tmp directory.  Our in-house version of this app is hooked up to BUGdata, which isn't public yet, but you can see the creations 'here(http://buglabs.net/data/drawpad_demo)':http://buglabs.net/data/drawpad_demo."
HOMEPAGE = "http://buglabs.net/applications/Draw+Pad"

DEPENDS += "com.buglabs.bug.module.camera com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/391"

APIVERSION = ""

BROKEN = "1"
