DESCRIPTION = "Opencv : The Open Computer Vision Library"
HOMEPAGE = "http://sourceforge.net/projects/opencvlibrary"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "libtool swig swig-native python jpeg zlib libpng tiff glib-2.0"

SRC_URI = "cvs://anonymous@opencvlibrary.cvs.sourceforge.net/cvsroot/opencvlibrary;module=opencv \
           file://acinclude.m4"

SRCDATE = "20081115"
PV = "1.0.0+cvs${SRCDATE}"

S = "${WORKDIR}/opencv"

inherit distutils-base autotools pkgconfig

EXTRA_OECONF = " \
		--disable-debug \
		--with-gtk \
		--enable-apps \
		--with-python az_python_cspec=${STAGING_INCDIR}/${PYTHON_DIR} \
		"

export BUILD_SYS
export HOST_SYS
export PYTHON_CSPEC="-I${STAGING_INCDIR}/${PYTHON_DIR}"

do_configure_prepend() {
	cp ${WORKDIR}/acinclude.m4 ${S}
	sed -i -e /AC_CONFIG_MACRO_DIR/d -e /AZ_PYTHON_CSPEC/d ${S}/configure.in
}

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

