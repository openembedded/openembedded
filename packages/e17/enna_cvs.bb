DESCRIPTION = "Enna is a media center application based on EFL"
LICENSE = "GPL"
DEPENDS = "curl dbus eet evas edje ecore edbus emotion"
DEPENDS += "libmusicbrainz lightmediascanner libxml2 taglib"
SECTION = "x11/multimedia"
PV = "0.2.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=misc/enna"
S = "${WORKDIR}/enna"

do_configure_prepend() {
    autopoint
}
