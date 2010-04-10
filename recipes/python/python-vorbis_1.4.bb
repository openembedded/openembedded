DESCRIPTION = "Python Vorbis Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libvorbis python-ogg"
SRCNAME = "pyvorbis"
PR = "ml0"

SRC_URI = "http://www.andrewchatham.com/pyogg/download/${SRCNAME}-${PV}.tar.gz \
           file://disable-oggcheck.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	touch Setup
	echo "ogg_libs = ogg" >>Setup
	echo "ogg_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "ogg_include_dir = ${STAGING_INCDIR}" >>Setup
	echo "vorbis_libs = vorbis vorbisfile vorbisenc" >>Setup
	echo "vorbis_lib_dir = ${STAGING_LIBDIR}" >>Setup
	echo "vorbis_include_dir = ${STAGING_INCDIR}" >>Setup
}

SRC_URI[md5sum] = "b4921e792c0a74f75b9d3057df10ee7c"
SRC_URI[sha256sum] = "a7154541cea58304feff30752243eab862131c7589d72c200c8ad722d3bf1647"
