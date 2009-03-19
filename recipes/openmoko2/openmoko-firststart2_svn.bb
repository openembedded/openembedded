DESCRIPTION = "The Openmoko First Start Wizard"
SECTION = "openmoko/apps"
DEPENDS += "libmokoui2 libglade"
PV = "0.1.0+svnr${SRCREV}"
PR = "r0"

inherit openmoko2

FILES_${PN} += "${datadir}"
