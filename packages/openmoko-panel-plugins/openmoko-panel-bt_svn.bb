DESCRIPTION = "Shows the bluetooth status in the OpenMoko panel"
DEPENDS = "bluez-libs"
PV = "0.1.0+svn${SVNREV}"
PR = "r1"

inherit openmoko-panel-plugin

SRC_URI += "file://panel-bluetooth.patch;patch=1" 

