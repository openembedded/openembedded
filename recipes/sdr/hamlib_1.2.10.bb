DESCRIPTION = "The Ham Radio Control Libraries, Hamlib for short, is a development effort to provide a consistent interface for programmers wanting to incorporate radio control in their programs"
LICENSE = "GPLv2"

DEPENDS = "swig-native perl python virtual/libusb0 tcl gnuradio"

SRC_URI = "${SOURCEFORGE_MIRROR}/hamlib/hamlib-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-perl-inc=${STAGING_LIBDIR}/perl/5.8.8/CORE"
# This is a hack, someone with some more time should fix the autofoo
do_configure() {
	oe_runconf
}

PARALLEL_MAKE = ""

do_compile_prepend() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e 's:${STAGING_LIBDIR_NATIVE}:${STAGING_LIBDIR}:g' \
		       -e s:-L/usr/local/lib::g \
			   -e 's:\"$(CC)\":\"${CC}\" LD=\"${LD}\" LDFLAGS=\"${LDFLAGS}\":g' \
		       -e s:${STAGING_INCDIR_NATIVE}/python2.6:${STAGING_INCDIR}/python2.6:g $i 
	done
}

# There's one perl module that doesn't honour CFLAGS :(
INSANE_SKIP_${PN} = True
FILES_${PN} = "${bindir} ${sbindir} ${libdir}/hamlib*.so ${libdir}/p*/ ${libdir}/tcl"
FILES_${PN}-dbg += "${libdir}/perl/*/auto/Hamlib/.debug/"

python populate_packages_prepend () {
	hamlib_libdir = bb.data.expand('${libdir}', d)
	hamlib_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, hamlib_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'hamlib %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, hamlib_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'hamlib %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, hamlib_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'hamlib %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, hamlib_libdir, '^lib(.*)\.so\.*', 'lib%s', 'hamlib %s library', extra_depends='', allow_links=True)
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"


