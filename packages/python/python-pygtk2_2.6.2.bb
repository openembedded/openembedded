DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "gtk+ libglade"
SRCNAME = "pygtk"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/2.6/${SRCNAME}-${PV}.tar.bz2 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig distutils-base

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_stage() {
	autotools_stage_includes
	install -m 0755 codegen/pygtk-codegen-2.0 ${STAGING_BINDIR}/
}

