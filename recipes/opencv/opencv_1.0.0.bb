DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

PR = "r3"

DEPENDS = "libtool swig swig-native python jpeg zlib libpng tiff glib-2.0"
#RDEPENDS_${PN} = "python jpeg zlib libpng tiff glib-2.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/opencvlibrary/opencv-${PV}.tar.gz \
          file://debian/010_enable_static.diff \
          file://debian/010_ffmpeg_linking.diff \
          file://debian/010_fix_optimisations.diff \
          file://debian/010_m4_syntax.diff \
          file://debian/010_makefile_syntax.diff \
          file://debian/010_python_cspec.diff \
          file://debian/020_python_linking.diff \
          file://debian/030_install_hook.diff \
          file://debian/050_rebootstrap.diff \
          file://debian/100_amd64.diff \
          file://debian/100_static_inline.diff \
          file://debian/100_ffmpeg_updates.diff \
          file://debian/110_dc1394.diff \
          file://debian/120_header_warnings.diff \
          file://debian/200_documentation.diff \
          file://debian/200_examples_makefile.diff \
          file://debian/210_openmp_compilation.diff \
          file://debian/300_fix_segfault_in_window_gtk.diff \
"

inherit distutils-base autotools pkgconfig

EXTRA_OECONF = "--disable-debug  --without-gtk --without-python --disable-apps az_python_cspec=${STAGING_INCDIR}/${PYTHON_DIR}"

export BUILD_SYS
export HOST_SYS

do_configure() {
	gnu-configize
	cp ${STAGING_DATADIR}/libtool/config.{sub,guess} autotools
	oe_runconf
}	

PACKAGES += "python-opencv"

python populate_packages_prepend () {
	cv_libdir = bb.data.expand('${libdir}', d)
	cv_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, cv_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, cv_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenCV %s library', extra_depends='', allow_links=True)
}

FILES_${PN}-doc += "${datadir}/opencv/"
FILES_${PN} = "${bindir}"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

DESCRIPTION_python-opencv = "Python bindings to opencv"
FILES_python-opencv = "${PYTHON_SITEPACKAGES_DIR}/*"
RDEPENDS_python-opencv = "python-core"

SRC_URI[md5sum] = "146a05005f2d2c16c4ee10ebd7f1dd58"
SRC_URI[sha256sum] = "3a6ee888e4dd4ab7f2bc80d046688c099c6a95d1267af554b7c8f1543b66f21e"
