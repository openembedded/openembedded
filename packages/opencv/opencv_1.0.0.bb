DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "libtool swig swig-native python jpeg zlib libpng tiff glib-2.0"
#RDEPENDS = "python jpeg zlib libpng tiff glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/opencvlibrary/opencv-${PV}.tar.gz \
          file://debian/010_enable_static.diff;patch=1 \
          file://debian/010_ffmpeg_linking.diff;patch=1 \
          file://debian/010_fix_optimisations.diff;patch=1 \
          file://debian/010_m4_syntax.diff;patch=1 \
          file://debian/010_makefile_syntax.diff;patch=1 \
          file://debian/010_python_cspec.diff;patch=1 \
          file://debian/020_python_linking.diff;patch=1 \
          file://debian/030_install_hook.diff;patch=1 \
          file://debian/050_rebootstrap.diff;patch=1 \
          file://debian/100_amd64.diff;patch=1 \
          file://debian/100_static_inline.diff;patch=1 \
          file://debian/100_ffmpeg_updates.diff;patch=1 \
          file://debian/110_dc1394.diff;patch=1 \
          file://debian/120_header_warnings.diff;patch=1 \
          file://debian/200_documentation.diff;patch=1 \
          file://debian/200_examples_makefile.diff;patch=1 \
          file://debian/210_openmp_compilation.diff;patch=1 \
          file://debian/300_fix_segfault_in_window_gtk.diff;patch=1 \
"

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

