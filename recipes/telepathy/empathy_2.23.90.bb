DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "python-native telepathy-python telepathy-mission-control libtelepathy telepathy-glib gtk+ gconf libglade eds-dbus"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

inherit gnome

PARALLEL_MAKE = ""
PR = "r1"

PACKAGES =+ "empathy-scrollkeeper-junk"
FILES_empathy-scrollkeeper-junk = "/var/lib/scrollkeeper"

FILES_${PN} += "${datadir}/mission-control/profiles/*.profile \
        ${datadir}/dbus-1/services/*.service \
        ${datadir}/telepathy/managers/*.chandler \
	${datadir}/icons \
	${libdir}/python*"

FILES_${PN}-dbg += "${libdir}/python*/*/.debug"


SRC_URI[archive.md5sum] = "9bd5b3aef85262f8ae3efdbe87a7dbf8"
SRC_URI[archive.sha256sum] = "ad2c7ca228cdc79405c3853e7fdbfd5c239a6e9ad9a1a237e7e1b0c0b10f3ad4"
