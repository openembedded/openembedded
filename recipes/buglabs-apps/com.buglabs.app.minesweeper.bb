require bug-app.inc

DESCRIPTION = "Minesweeper in java. Uses the IDesktopApp interface so you need R1.4.1 and AppUI installed on your bug.\
Only has easy as a level, anymore boxes might get a little small, 8x8 with 10 bombs.  You can switch between flipping boxes and flagging boxes by clicking on the Flip/Flag button.  The number on the right indicates how many more bombs you need to find.\
I still haven't figured out how when you click on a space with no bombs around it all the spaces with no bombs around it will also flip, you'll see what I mean."
HOMEPAGE = "http://buglabs.net/applications/Minesweeper"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/833"

APIVERSION = "1.4.1"
