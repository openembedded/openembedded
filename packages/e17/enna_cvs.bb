DESCRIPTION = "Enna is a media center application based on EFL"
LICENSE = "GPL"
DEPENDS = "curl dbus eet evas edje ecore edbus emotion libmusicbrainz libxml2 taglibc"
SECTION = "x11/multimedia"
PV = "0.2.0+cvs${SRCDATE}"

inherit e

SRC_URI = "${E_CVS};module=misc/enna \
           file://locale-is-broken.patch;patch=1"
S = "${WORKDIR}/enna"

do_configure_prepend() {
	touch po/Makefile.in.in
}
