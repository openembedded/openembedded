DESCRIPTION = "The Openmoko Feed Reader"
SECTION = "openmoko/apps"
DEPENDS += "libmokoui2 libmrss check webkit-gtk"
SRCREV = "3645"
PV = "0.0.1+svnr${SRCPV}"
PR = "r1"

inherit openmoko2
