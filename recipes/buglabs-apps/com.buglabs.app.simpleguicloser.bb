require bug-app.inc

DESCRIPTION = "Simple application (a la SimpleGUI from kschultz) demonstrating how to close a Frame by overriding the relevant methods in java.awt.event.WindowAdapter\
What it does:\
Constructs and shows a frame at half the screen resolution height and width.  \
Constructs a simple static label\
Constructs a canvas, which responds to MouseEvents by changing the background color (white for out, green for in) and prints to console information regarding the MouseEvent\
Registers an anonymous inner WindowAdapter to listen to the Frame for window events, disposing of the Frame (and printing to console) when the frame has been closed.\
\
\
What it shows:\
Use anonymous inner classing for speedy coding and convenient handling of events (MouseEvent, MouseAdapter).\
Use of anonymous inner WindowAdapter (abstract class) to handle WindowEvents\
\
For more information about AWT, WindowEvents, WindowAdapter, etc, please see here for brief overview:\
http://www.exampledepot.com/egs/java.awt/pkg.html\
For more information about use of Anonymous Inner Classing, see a short lecture at Stanford:\
\
\
Please feel free to email me at jconnolly [at] buglabs.net for information.  Or check out BUGLabs on IRC:\
irc://irc.freenode.net/buglabs\
"
HOMEPAGE = "http://buglabs.net/applications/SimpleGUICloser"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/337"

APIVERSION = ""
