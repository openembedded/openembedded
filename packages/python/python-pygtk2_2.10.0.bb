DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
# needs gtk+ 2.10.x
DEPENDS = "gtk+ libglade python-pygobject-native"
RDEPENDS = "python-shell"
SRCNAME = "pygtk"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/2.10/${SRCNAME}-${PV}.tar.bz2 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

EXTRA_OECONF = "--disable-docs"

inherit autotools pkgconfig distutils-base

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_stage() {
	autotools_stage_includes
	install -m 0755 codegen/pygtk-codegen-2.0 ${STAGING_BINDIR}/
}
