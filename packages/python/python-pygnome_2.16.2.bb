DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
DEPENDS = "python-pygtk2 libgnomeui"
RDEPENDS = "python-shell"
SRCNAME = "gnome-python"
LICENSE = "LGPL"
PR = "ml0"

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/gnome-python/2.16/${SRCNAME}-${PV}.tar.bz2 \
	   file://acinclude.m4 \
	   "

S = "${WORKDIR}/${SRCNAME}-${PV}"

EXTRA_OECONF = "--disable-docs"

inherit autotools pkgconfig distutils-base

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_stage() {
	autotools_stage_includes
}
