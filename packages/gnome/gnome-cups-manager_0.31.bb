DESCRIPTION="Gnome Cups Manager"
LICENSE="GPLv2"
PR="r0"

DEPENDS="glib-2.0 gtk+ pango libgnomecups"

inherit gnome pkgconfig

SRC_URI = "http://ftp.gnome.org/pub/gnome/sources/gnome-cups-manager/0.31/gnome-cups-manager-0.31.tar.bz2"

do_stage() {
autotools_stage_all
}

