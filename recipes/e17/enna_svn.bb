DESCRIPTION = "Enna is a media center application based on EFL"
LICENSE = "GPL"
DEPENDS = "curl dbus eet evas edje ecore edbus emotion"
DEPENDS += "libmusicbrainz lightmediascanner libxml2 taglib"
SECTION = "x11/multimedia"
PV = "0.2.0+svnr${SRCPV}"
PR = "r1"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/MISC;module=enna;proto=http"
S = "${WORKDIR}/enna"

FILES_${PN}-dbg += "${libdir}/${PN}/modules/.debug"
