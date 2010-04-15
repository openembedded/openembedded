DESCRIPTION="Gnome Cups Manager"
LICENSE="GPLv2"

PR = "r1"

DEPENDS="glib-2.0 gtk+ pango libgnomecups"

inherit gnome pkgconfig

FILES_${PN} += "${datadir}/icons/"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/gnome-cups-manager/${PV}/gnome-cups-manager-${PV}.tar.bz2"

SRC_URI[md5sum] = "a48eb85cd239760913c936d824062473"
SRC_URI[sha256sum] = "9d4fdefc8f69c0e1b330bb399b162f1f1005afdadf346e4f5d739de75c660dca"
