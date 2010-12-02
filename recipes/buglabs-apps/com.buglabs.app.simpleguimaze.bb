require bug-app.inc

DESCRIPTION = "This App modifies the SimpleGUI app and displays a maze each time the button is clicked.\
NOTE: Due to some inconsistencies between character output in java and in the BUG, some of the vertical barriers of the maze may be slightly off line."
HOMEPAGE = "http://buglabs.net/applications/SimpleGUIMaze"

DEPENDS += "com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.osgi service-tracker "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/1145"

APIVERSION = "1.4.3"
