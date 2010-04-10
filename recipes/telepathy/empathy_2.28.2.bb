DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "libcanberra telepathy-farsight gnome-doc-utils \
python-native telepathy-python telepathy-mission-control \
libtelepathy telepathy-glib gtk+ gconf libglade eds-dbus \
libunique"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

inherit gnome

SRC_URI += "file://fix-xml-threadbreakage.patch;patch=1"

PARALLEL_MAKE = ""

PACKAGES =+ "empathy-scrollkeeper-junk"
FILES_empathy-scrollkeeper-junk = "/var/lib/scrollkeeper"

FILES_${PN} += "${datadir}/mission-control/profiles/*.profile \
        ${datadir}/dbus-1/services/*.service \
        ${datadir}/telepathy/ \
	${datadir}/icons \
	${libdir}/python*"

FILES_${PN}-dbg += "${libdir}/python*/*/.debug"


SRC_URI[archive.md5sum] = "8d578d82d1e51dc8c83642b81c0fb65a"
SRC_URI[archive.sha256sum] = "8f1dc1cbf7bda0dcb9804d5aa5d5d0e625c35dee10bfba7050aa3a8b6d491f3b"
