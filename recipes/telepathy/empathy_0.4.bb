DESCRIPTION = "Empathy: a Telepathy based IM client"
HOMEPAGE = "http://blogs.gnome.org/view/xclaesse/2007/04/26/0"
LICENSE = "GPL"
DEPENDS = "libgnomeui telepathy-mission-control libtelepathy gtk+ gconf libglade"
RDEPENDS = "telepathy-mission-control"
RRECOMMENDS = "telepathy-gabble"

PR ="r0"

inherit gnome

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/empathy/0.4/empathy-${PV}.tar.bz2 \
          "

FILES_${PN} += "${datadir}/mission-control/profiles/*.profile \
        ${datadir}/dbus-1/services/*.service \
        ${datadir}/telepathy/managers/*.chandler \
	${datadir}/icons"
