DESCRIPTION = "Enna is a media center application based on EFL"
LICENSE = "GPL"
DEPENDS = "curl dbus eet evas edje ecore edbus emotion libmusicbrainz libxml2 taglib"
SECTION = "x11/multimedia"
PV = "0.2.0+svn${SRCDATE}"

inherit e

SRC_URI = "svn://enna.svn.sourceforge.net/svnroot/enna/trunk;module=enna;proto=http"
S = "${WORKDIR}/enna"

