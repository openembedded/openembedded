DESCRIPTION = "The Ham Radio Control Libraries, Hamlib for short, is a development effort to provide a consistent interface for programmers wanting to incorporate radio control in their programs"
LICENSE = "GPLv2"

DEPENDS = "swig-native perl python virtual/libusb0 tcl gnuradio"

SRC_URI = "${SOURCEFORGE_MIRROR}/hamlib/hamlib-${PV}.tar.gz"
SRC_URI[md5sum] = "914835c0fe4d618d1cd62f1fd0a8dd7d"
SRC_URI[sha256sum] = "735782ecd83de4036cef7dfcc87eac5095420406bd0ac2262d967e808c2d108c"

inherit autotools

EXTRA_OECONF = "--with-perl-inc=${STAGING_LIBDIR}/perl/5.10.1/CORE"

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
