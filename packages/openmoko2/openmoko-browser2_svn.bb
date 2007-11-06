DESCRIPTION = "The OpenMoko Webbrowser"
SECTION = "openmoko/apps"
DEPENDS += "intltool libmokoui2 check webkit-gtk"
PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

inherit openmoko2

#SRC_URI += "file://fingerscroll.diff;patch=1"


