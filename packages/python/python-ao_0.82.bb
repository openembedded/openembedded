LICENSE = "GPL"
DESCRIPTION = "Python AO Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "libao"
SRCNAME = "pyao"

SRC_URI = "http://www.andrewchatham.com/pyogg/download/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	touch Setup
	echo "ao_libs = ao" >>Setup
	echo "ao_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "ao_include_dir = ${STAGING_INCDIR}" >>Setup
}


