DESCRIPTION = "The Ham Radio Control Libraries, Hamlib for short, is a development effort to provide a consistent interface for programmers wanting to incorporate radio control in their programs"
LICENSE = "GPLv2"

DEPENDS = "swig-native python libusb-compat tcl gnuradio"

SRC_URI = "${SOURCEFORGE_MIRROR}/hamlib/hamlib-${PV}.tar.gz"

inherit autotools_stage

# This is a hack, someone with some more time should fix the autofoo
do_configure() {
	oe_runconf
}

PARALLEL_MAKE = ""

do_compile_prepend() {
	mkdir -p ${STAGING_LIBDIR}/.libs
	ln -sf ${STAGING_LIBDIR}/libusb* ${STAGING_LIBDIR}/.libs/
}

FILES_${PN} = "${bindir} ${sbindir} ${libdir}/hamlib*"

python populate_packages_prepend () {
	cv_libdir = bb.data.expand('${libdir}', d)
	cv_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, cv_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'hamlib %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, cv_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'hamlib %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'hamlib %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, cv_libdir, '^lib(.*)\.so\.*', 'lib%s', 'hamlib %s library', extra_depends='', allow_links=True)
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"


