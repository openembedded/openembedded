DESCRIPTION = "Python GTK+ Bindings"
SECTION = "devel/python"
DEPENDS = "gtk+-2.6.10 libglade"
RDEPENDS = "python-shell"
SRCNAME = "pygtk"
LICENSE = "LGPL"
PR = "ml0"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/${MAJ_VER}/${SRCNAME}-${PV}.tar.bz2 \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig distutils-base

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-doc ${PN}"
FILES_${PN}-dev += "${bindir} ${datadir}/pygtk ${libdir}/pygtk"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_stage() {
	autotools_stage_includes
	sed -i s:/usr/share:${STAGING_DATADIR}: codegen/pygtk-codegen-2.0
	install -m 0755 codegen/pygtk-codegen-2.0 ${STAGING_BINDIR_NATIVE}/
	install -d ${STAGING_DATADIR}/pygtk/2.0/codegen
	install -d ${STAGING_DATADIR}/pygtk/2.0/defs/
	cp -pPr codegen/*.py* ${STAGING_DATADIR}/pygtk/2.0/codegen/
	cp -pPr *.defs ${STAGING_DATADIR}/pygtk/2.0/defs/
	cp -pPr gtk/*.defs ${STAGING_DATADIR}/pygtk/2.0/defs/
}
