DESCRIPTION = "Python Ogg Vorbis Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
DEPENDS = "libogg"
SRCNAME = "pyogg"

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
