DESCRIPTION = "Perl-compatible regular expression library. PCRE has its own native \
API, but a set of 'wrapper' functions that are based on the POSIX API \
are also supplied in the library libpcreposix. Note that this just \
provides a POSIX calling interface to PCRE; the regular expressions \
themselves still follow Perl syntax and semantics. The header file for \
the POSIX-style functions is called pcreposix.h."
SECTION = "devel"
PR = "r1"
LICENSE = "BSD"
SRC_URI = "ftp://ftp.csx.cam.ac.uk/pub/software/programming/pcre/pcre-${PV}.tar.bz2"
S = "${WORKDIR}/pcre-${PV}"

inherit autotools binconfig

PARALLEL_MAKE=""

LEAD_SONAME = "libpcre.so"
CFLAGS_append = " -D_REENTRANT"
EXTRA_OECONF = " --with-link-size=2 --enable-newline-is-lf --with-match-limit=10000000"

do_compile () {
	# The generation of dftables can lead to timestamp problems with ccache
	# because the generated config.h seems newer.  It is sufficient to ensure that the
	# attempt to build dftables inside make will actually work (foo_FOR_BUILD is
	# only used for this).
	oe_runmake CC_FOR_BUILD="${BUILD_CC}" CFLAGS_FOR_BUILD="-DLINK_SIZE=2 -I${S}/include" LINK_FOR_BUILD="${BUILD_CC}"
}

do_stage () {
	# Force all -L(dir) output to be prepended with the staging libdir to stop libtool
	# from trying to link to host libraries.
	sed -i 's:-L\$:-L${STAGING_LIBDIR} -L\$:' ${S}/*libtool

	oe_libinstall -a -so libpcre ${STAGING_LIBDIR}
	oe_libinstall -a -so libpcreposix ${STAGING_LIBDIR}
	install -m 0644 pcre.h ${STAGING_INCDIR}/
	install -m 0644 pcreposix.h ${STAGING_INCDIR}/

	# pcreposix linked originally to the libpcre in it's working directory. That messed
	# the .la file up. I fix this manually here:
	sed -i 's:${S}:${STAGING_LIBDIR}:' ${STAGING_LIBDIR}/libpcreposix.la
}

FILES_${PN} = "${libdir}/lib*.so*"
FILES_${PN}-dev += "${bindir}"
