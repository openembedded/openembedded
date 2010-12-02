require bug-app.inc

DESCRIPTION = "This application shows users how they may use the on-screen-keyboard with their bug apps.  \
Requirements:\
This App works on R1.3 and R1.4 of the BUG rootfilesystem.  Requires only the LCD module.  (note, in R1.3, java apps render on LCD screens plugged into slots 1,3 [above/below joystick], on R1.4 it is the opposite side, slots 0,2 [above/below hotkeys]).\
What it does:\
Displays a frame containing an editable text area, and invokes matchbox-keyboard to use to enter text into the text area.\
What it shows:\
How to use the on-screen-keyboard in your app."
HOMEPAGE = "http://buglabs.net/applications/OnScreenKeyboardExample"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/528"

APIVERSION = ""
