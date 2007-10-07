DESCRIPTION = "The OpenMoko Command Line Console"
SECTION = "openmoko/applications"
DEPENDS = "vte libmokoui2"
RDEPENDS = "ttf-liberation-mono"
PV = "2.1.0+${SVNREV}"
PR = "r2"

inherit openmoko2
