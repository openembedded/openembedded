DESCRIPTION = "The OpenMoko Command Line Console"
SECTION = "openmoko/applications"
DEPENDS = "vte libmokoui2"
RDEPENDS = "ttf-liberation-mono"
PV = "2.1.1+svnr${SRCREV}"
PR = "r2"

inherit openmoko2
