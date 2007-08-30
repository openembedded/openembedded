DESCRIPTION = "A media player for OpenMoko"
SECTION = "openmoko/tools"
DEPENDS = "libmokoui2 expat gstreamer libspiff"
PV = "0.1.0+svn${SVNREV}"
PR = "r0"

inherit openmoko2

FILES_${PN} += "${datadir}/openmoko-mediaplayer"

