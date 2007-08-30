DESCRIPTION = "The OpenMoko First Start Wizard"
SECTION = "openmoko/apps"
DEPENDS += "libmokoui2 libglade"
PV = "0.1.0+svn${SVNREV}"
PR = "r0"

inherit openmoko2

FILES_${PN} += "${datadir}"
