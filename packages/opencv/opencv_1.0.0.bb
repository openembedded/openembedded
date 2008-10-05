DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "libtool swig swig-native python jpeg zlib libpng tiff glib-2.0"
#RDEPENDS = "python jpeg zlib libpng tiff glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/opencvlibrary/opencv-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-debug --disable-apps"

do_configure() {
	gnu-configize
	cp ${STAGING_DATADIR}/libtool/config.{sub,guess} autotools
	oe_runconf
}	


PACKAGES = "${PN} ${PN}-dev ${PN}-doc ${PN}-dbg python-opencv"

FILES_${PN} = "${libdir}/*.so*"
# ${libdir}/libcv.so* \
# ${libdir}/libcvaux.so* \
# ${libdir}/libcxcore.so* \
# ${libdir}/libhighgui.so* \
# ${libdir}/libml.so* "

FILES_${PN}-dev += " ${libdir}/*.la "
FILES_${PN}-doc += "${datadir}/opencv/"
FILES_${PN}-dbg += "${libdir}/.debug/"

DESCRIPTION_python-opencv = "Python bindings to opencv"
FILES_python-opencv = "${libdir}/*/site-packages/*"
RDEPENDS_python-opencv = "python-core opencv"

LEAD_SONAME = "libcv.so"

do_stage() {
	autotools_stage_all
}

