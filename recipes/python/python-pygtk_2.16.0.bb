DESCRIPTION = "Python GTK+ 2.10.x Bindings"
SECTION = "devel/python"
# needs gtk+ 2.10.x
DEPENDS = "gtk+ libglade python-pycairo python-pygobject"
RDEPENDS_${PN} = "python-shell python-pycairo python-pygobject"
PROVIDES = "python-pygtk2"
SRCNAME = "pygtk"
LICENSE = "LGPLv2.1"
PR = "r4"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "ftp://ftp.gnome.org/pub/gnome/sources/pygtk/${MAJ_VER}/${SRCNAME}-${PV}.tar.bz2;name=pygtk \
           file://fix-gtkunixprint.patch \
           file://acinclude.m4"
S = "${WORKDIR}/${SRCNAME}-${PV}"

EXTRA_OECONF = "\
  --disable-docs \
  --with-python-includes=${STAGING_INCDIR}/../ \
"

inherit autotools pkgconfig distutils-base

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	sed -i \
		-e s:'`$PKG_CONFIG --variable defsdir pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/defs\":g \
		-e s:'`$PKG_CONFIG --variable=pygtkincludedir pygobject-2.0`':\"${STAGING_INCDIR}/pygtk-2.0\":g \
		-e s:'`$PKG_CONFIG --variable=datadir pygobject-2.0`':\"${STAGING_DATADIR}\":g \
		-e s:'`$PKG_CONFIG --variable codegendir pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/codegen\":g \
		-e s:'`$PKG_CONFIG --variable=fixxref pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/xsl/fixxref.py\":g \
		${S}/configure.ac
	sed -i 's:tests docs:tests:' Makefile.am
}

# dirty fix #1: remove dependency on python-pygobject-dev
do_install_append() {
	find ${D} -name "*.la"|xargs rm -f
	rm -f ${D}/${bindir}/pygtk-codegen-2.0
	rm -rf ${D}/${libdir}/pkgconfig
	install -d ${D}${libdir}/pkgconfig
	install -m 0644 ${S}/*.pc ${D}${libdir}/pkgconfig
}

# dirty fix #2: fix build system paths leaking in
require fix-path.inc

PACKAGES =+ "${PN}-demo"
FILES_${PN}-demo = "\
  ${bindir}/pygtk-demo \
  ${libdir}/pygtk \
"
RDEPENDS_${PN}-demo = "python-pygtk python-stringold python-lang"

# todo: revamp packaging, package demo seperatly
FILES_${PN}-dev += "\
  ${libdir}/pygtk/2.0 \
  ${bindir}/pygtk-* \
  ${datadir}/pygtk/2.0"


SRC_URI[pygtk.md5sum] = "bd0d437fefd6d5390f5d770a495cd50c"
SRC_URI[pygtk.sha256sum] = "7fae5e01af217a01738eae41c38ad7f86d1f538f444300d0fa2847aafb7444a8"
