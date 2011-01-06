DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "ffmpeg gtk+ libtool swig swig-native python jpeg bzip2 zlib libpng tiff glib-2.0"

SRC_URI = "svn://code.ros.org/svn/opencv/trunk;module=opencv;proto=https \
"

SRCREV = "3241"
PV = "2.1.0+svnr${SRCPV}"
PR = "r2"

S = "${WORKDIR}/opencv"

inherit distutils-base autotools pkgconfig cmake

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

ALLOW_EMPTY_${PN} = "1"

INSANE_SKIP_python-opencv = True
DESCRIPTION_python-opencv = "Python bindings to opencv"
FILES_python-opencv = "${PYTHON_SITEPACKAGES_DIR}/*"
RDEPENDS_python-opencv = "python-core"

do_install_append() {
	cp ${S}/include/opencv/*.h ${D}${includedir}/opencv/
	sed -i '/blobtrack/d' ${D}${includedir}/opencv/cvaux.h
}
