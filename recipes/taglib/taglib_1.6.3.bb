DESCRIPTION = "TagLib is a library for reading and editing the meta-data of several popular audio formats"
SECTION = "libs/multimedia"
HOMEPAGE = "http://developer.kde.org/~wheeler/taglib.html"
LICENSE = "LGPL"
 
SRC_URI = "http://developer.kde.org/~wheeler/files/src/taglib-${PV}.tar.gz \
	  "
SRC_URI[md5sum] = "ddf02f4e1d2dc30f76734df806e613eb"
SRC_URI[sha256sum] = "a9ba089cc2c6d26d266bad492de31cadaeb878dea858e22ae3196091718f284b"

inherit cmake pkgconfig binconfig

EXTRA_OECMAKE = "-DWITH_MP4=1"

LEAD_SONAME = "libtag.so.1"

PACKAGES =+ "${PN}-c"

FILES_${PN} = "${libdir}/libtag.so.*"
FILES_${PN}-c = "${libdir}/libtag_c.so.*"
