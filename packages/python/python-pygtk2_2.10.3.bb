DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
# needs gtk+ 2.10.x
DEPENDS = "gtk+ libglade python-pycairo python-pygobject"
RDEPENDS = "python-shell"
SRCNAME = "pygtk"
LICENSE = "LGPL"
PR = "ml2"

SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/2.10/${SRCNAME}-${PV}.tar.bz2 \
           file://fix-gtkunixprint.patch;patch=1 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

EXTRA_OECONF = "--disable-docs"

inherit autotools pkgconfig distutils-base

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_stage() {
	autotools_stage_includes
        sed -i s:/usr/share:${STAGING_DATADIR}: codegen/pygtk-codegen-2.0
        install -m 0755 codegen/pygtk-codegen-2.0 ${STAGING_BINDIR}/
	install -d ${STAGING_DATADIR}/pygtk/2.0/codegen
	install -d ${STAGING_DATADIR}/pygtk/2.0/defs/
	cp -pPr codegen/*.py* ${STAGING_DATADIR}/pygtk/2.0/codegen/
	cp -pPr *.defs ${STAGING_DATADIR}/pygtk/2.0/defs/
	cp -pPr gtk/*.defs ${STAGING_DATADIR}/pygtk/2.0/defs/
}
