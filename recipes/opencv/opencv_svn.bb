DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "ffmpeg gtk+ libtool swig swig-native python jpeg zlib libpng tiff glib-2.0"

SRC_URI = "svn://opencvlibrary.svn.sourceforge.net/svnroot/opencvlibrary/trunk;module=opencv;proto=https \
           file://acinclude.m4"

SRCREV = "2027"
PV = "1.0.0+1.1pre1+svnr${SRCREV}"

S = "${WORKDIR}/opencv"

inherit distutils-base autotools pkgconfig

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
		--without-python az_python_cspec=${STAGING_INCDIR}/${PYTHON_DIR} \
		"

export BUILD_SYS
export HOST_SYS
export PYTHON_CSPEC="-I${STAGING_INCDIR}/${PYTHON_DIR}"

do_configure_prepend() {
	cp ${WORKDIR}/acinclude.m4 ${S}
	sed -i -e /AC_CONFIG_MACRO_DIR/d -e /AZ_PYTHON_CSPEC/d ${S}/configure.in
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
FILES_${PN}-doc += "${datadir}/opencv/"
FILES_${PN}-apps = "${bindir}/*"
FILES_${PN}-dbg += "${libdir}/.debug"
FILES_${PN}-dev = "${includedir} ${libdir}/pkgconfig"

DESCRIPTION_python-opencv = "Python bindings to opencv"
FILES_python-opencv = "${libdir}/*/site-packages/*"
RDEPENDS_python-opencv = "python-core"

do_stage() {
	autotools_stage_all
}

