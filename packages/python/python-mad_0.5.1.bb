DESCRIPTION = "Python libmad Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
RDEPENDS = "python-core libmad"
DEPENDS = "libmad"
SRCNAME = "pymad"

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
