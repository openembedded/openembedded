DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "telepathy-mission-control libtelepathy gtk+ gconf libglade gnome-vfs"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

PR ="r1"

inherit gnome

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/empathy/0.5/empathy-${PV}.tar.bz2 \
           file://no-gnome.diff;patch=1;pnum=0"

FILES_${PN} += "${datadir}/mission-control/profiles/*.profile \
        ${datadir}/dbus-1/services/*.service \
        ${datadir}/telepathy/managers/*.chandler \
	${datadir}/icons"

SRC_URI[md5sum] = "e363689295c78ad62d323111a0176ea5"
SRC_URI[sha256sum] = "3807d778ea57b9a72a17d6f7c4c623f3b12546d9fc6a0b1da8c3f713fd6e4a15"
