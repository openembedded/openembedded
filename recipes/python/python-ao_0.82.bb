DESCRIPTION = "Python Bindings for libao"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libao"
SRCNAME = "pyao"
PR = "ml1"

SRC_URI = "http://www.andrewchatham.com/pyogg/download/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	touch Setup
	echo "ao_libs = ao" >>Setup
	echo "ao_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "ao_include_dir = ${STAGING_INCDIR}" >>Setup
}

SRC_URI[md5sum] = "8e00f5154401a6f6d99efd20606e2819"
SRC_URI[sha256sum] = "9a444518252f6d747e76a219e5efbc05b4e1742260a7419da9ddf93a519b30c5"
