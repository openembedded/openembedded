DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "ffmpeg gtk+ libtool swig swig-native python jpeg zlib libpng tiff glib-2.0"

SRC_URI = "svn://opencvlibrary.svn.sourceforge.net/svnroot/opencvlibrary/trunk;module=opencv;proto=https \
           file://acinclude.m4"

SRCREV = "2219"
PV = "2.0.0+svnr${SRCPV}"

S = "${WORKDIR}/opencv"

inherit distutils-base autotools_stage pkgconfig cmake

EXTRA_OECONF = " \
		--disable-debug \
		--with-gtk \
		--without-quicktime \
		--with-ffmpeg \
		--with-gthread \
		--without-gstreamer \
		--with-v4l \
		--enable-apps \
		--enable-optimization \
		--disable-sse \
		--with-swig \
		--with-python az_python_cspec=${STAGING_INCDIR}/${PYTHON_DIR} \
		"

export BUILD_SYS
export HOST_SYS
export PYTHON_CSPEC="-I${STAGING_INCDIR}/${PYTHON_DIR}"
export PYTHON=${STAGING_BINDIR_NATIVE}/python

do_configure_prepend() {
	cp ${WORKDIR}/acinclude.m4 ${S}
	sed -i -e /AC_CONFIG_MACRO_DIR/d -e /AZ_PYTHON_CSPEC/d ${S}/configure.in
	sed -i -e s:samples::g -e 's: doc::g' ${S}/Makefile.am
}

TARGET_CC_ARCH += "-I${S}/include "

PACKAGES += "${PN}-apps python-opencv"

python populate_packages_prepend () {
	cv_libdir = bb.data.expand('${libdir}', d)
	cv_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, cv_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, cv_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'OpenCV %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenCV %s library', extra_depends='', allow_links=True)
}

FILES_${PN} = ""
FILES_${PN}-apps = "${bindir}/* ${datadir}/opencv/"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

INSANE_SKIP_python-opencv = True
DESCRIPTION_python-opencv = "Python bindings to opencv"
FILES_python-opencv = "${PYTHON_SITEPACKAGES_DIR}/*"
RDEPENDS_python-opencv = "python-core"

do_stage_append() {
	cp ${S}/include/opencv/*.h ${STAGING_INCDIR}/opencv/
}
