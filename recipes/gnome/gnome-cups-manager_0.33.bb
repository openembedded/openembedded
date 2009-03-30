DESCRIPTION="Gnome Cups Manager"
LICENSE="GPLv2"

PR ="r0"

DEPENDS="glib-2.0 gtk+ pango libgnomecups"

inherit gnome pkgconfig

FILES_${PN} += "${datadir}/icons/"

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/gnome-cups-manager/${PV}/gnome-cups-manager-${PV}.tar.bz2"

do_stage() {
	autotools_stage_all
}

