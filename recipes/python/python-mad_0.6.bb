DESCRIPTION = "Python libmad Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://spacepants.org/src/pymad/"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libmad"
SRCNAME = "pymad"
PR = "ml1"

SRC_URI = "http://spacepants.org/src/pymad/download/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	touch Setup
	echo "endian = little" >>Setup # FIXME, not always true
	echo "mad_libs = mad" >>Setup
	echo "mad_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "mad_include_dir = ${STAGING_INCDIR}" >>Setup
}

SRC_URI[md5sum] = "a1405fb4b610348565c8d0e400c5ff18"
SRC_URI[sha256sum] = "1c9fc529b78de7d26e9e47cf182c9f8bf43838d8f62a9c1773540d57f5ebc522"
