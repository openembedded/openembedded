DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "libcanberra telepathy-farsight gnome-doc-utils python-native telepathy-python telepathy-mission-control libtelepathy telepathy-glib gtk+ gconf libglade eds-dbus"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

inherit gnome

PARALLEL_MAKE = ""

PACKAGES =+ "empathy-scrollkeeper-junk"
FILES_empathy-scrollkeeper-junk = "/var/lib/scrollkeeper"

FILES_${PN} += "${datadir}/mission-control/profiles/*.profile \
        ${datadir}/dbus-1/services/*.service \
        ${datadir}/telepathy/managers/*.chandler \
	${datadir}/icons \
	${libdir}/python*"

FILES_${PN}-dbg += "${libdir}/python*/*/.debug"


SRC_URI[archive.md5sum] = "1edc492c0fd339dc30f0a443adad5fbe"
SRC_URI[archive.sha256sum] = "bb3b3663b11e3e573a13dd1b51d8a5b02797a43c53a64efc529f6604f40503c7"
