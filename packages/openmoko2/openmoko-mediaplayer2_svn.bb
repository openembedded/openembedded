DESCRIPTION = "A media player for OpenMoko"
SECTION = "openmoko/tools"
DEPENDS = "libmokoui2 expat gstreamer libspiff curl"
RDEPENDS = "gst-meta-audio"
PV = "0.1.0+svnr${SRCREV}"
PR = "r2"

inherit openmoko2

FILES_${PN} += "${datadir}/openmoko-mediaplayer"
