DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "telepathy-mission-control libtelepathy gtk+ gconf libglade gnome-vfs"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

PR ="r0"

inherit gnome

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/empathy/${PV}/empathy-${PV}.tar.bz2"

FILES_${PN} += "${datadir}/mission-control/profiles/*.profile \
        ${datadir}/dbus-1/services/*.service \
        ${datadir}/telepathy/managers/*.chandler \
	${datadir}/icons"

SRC_URI[md5sum] = "676154eddfb47f212e4716bebc0fdf26"
SRC_URI[sha256sum] = "170d61f1387221b3034a777eb835d5b85d23ddb58d4d81ac42480e4e9ea138a6"
