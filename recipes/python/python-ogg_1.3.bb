DESCRIPTION = "Python Ogg Vorbis Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libogg"
SRCNAME = "pyogg"
PR = "r1"

SRC_URI = "http://www.andrewchatham.com/pyogg/download/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	touch Setup
	echo "ogg_libs = ogg" >>Setup
	echo "ogg_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "ogg_include_dir = ${STAGING_INCDIR}" >>Setup
}

do_stage() {
	install -d ${STAGING_INCDIR}/pyogg
	install -m 0644 include/pyogg/pyogg.h ${STAGING_INCDIR}/pyogg/pyogg.h
}

SRC_URI[md5sum] = "45a4ecc4d0600661199e4040a81ea3fe"
SRC_URI[sha256sum] = "10051f2894e901037dfa05b3c604fbdd76d891b9db2213a3c4f24ae79fbcc2a4"
