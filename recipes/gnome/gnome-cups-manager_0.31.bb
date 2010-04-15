DESCRIPTION="Gnome Cups Manager"
LICENSE="GPLv2"

PR = "r1"

DEPENDS="glib-2.0 gtk+ pango libgnomecups"

inherit gnome pkgconfig

FILES += "${datadir}/icons/hicolor/48x48/stock/data/emblem-*.png \
	  ${datadir}/icons/hicolor/48x48/devices/gnome-dev-printer-new.png"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/gnome-cups-manager/${PV}/gnome-cups-manager-${PV}.tar.bz2"

SRC_URI[md5sum] = "4144b2cf05e381e89fed066793e3b249"
SRC_URI[sha256sum] = "8ccfd3816757fa8127cf96a530e374c81a449fbcd9391d2d3e1bac29f54ab3e6"
