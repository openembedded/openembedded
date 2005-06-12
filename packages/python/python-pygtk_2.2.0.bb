DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "gtk+ libglade"
RDEPENDS = "python-shell"
SRCNAME = "pygtk"
LICENSE = "LGPL"
PR = "r3"

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/2.2/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig distutils-base

do_stage() {
	autotools_stage_includes
}

