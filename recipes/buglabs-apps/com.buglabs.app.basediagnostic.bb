require bug-app.inc

DESCRIPTION = "A basic diagnostic app for your BUGbase.  It just confirms that it is responsive and working physically.  \
Hotkey 1 lights up the LED behind Hotkey 1\
Hotkey 2 lights up the LED behind Hotkey 2\
Hotkey 3 lights up the LED behind Hotkey 3\
Hotkey 4 lights up the LED behind Hotkey 4\
Joystick UP    lights up the LED behind Hotkey 1\
Joystick DOWN  lights up the LED behind Hotkey 2\
Joystick LEFT  lights up the LED behind Hotkey 3\
Joystick RIGHT lights up the LED behind Hotkey 4\
Select button lights up the LED behind Hotkey 1\
Additionally,\
if the instructions (for Ubuntu/linux) are followed at http://buglabs.net/start and an http server daemon is started (lighttpd, for example) and a socket can be opened from BUG to port 80 (on 10.10.10.1), Hotkey2 will remain lit.  If this connection is dropped, hotkey2 LED will be off."
HOMEPAGE = "http://buglabs.net/applications/BaseDiagnostic"

DEPENDS += "com.buglabs.bug.base com.buglabs.osgi service-tracker com.buglabs.common "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/800"

APIVERSION = ""
