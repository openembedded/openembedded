DESCRIPTION = "Perl-compatible regular expression library. PCRE has its own native \
API, but a set of 'wrapper' functions that are based on the POSIX API \
are also supplied in the library libpcreposix. Note that this just \
provides a POSIX calling interface to PCRE; the regular expressions \
themselves still follow Perl syntax and semantics. The header file for \
the POSIX-style functions is called pcreposix.h."
SECTION = "devel"
PR = "r3"
LICENSE = "BSD"
SRC_URI = "${SOURCEFORGE_MIRROR}/pcre/pcre-${PV}.tar.bz2 \
           file://pcre-cross.patch;patch=1"
S = "${WORKDIR}/pcre-${PV}"

PROVIDES = "pcre"

inherit autotools binconfig

PARALLEL_MAKE = ""

LEAD_SONAME = "libpcre.so"
CFLAGS_append = " -D_REENTRANT"
CXXFLAGS_powerpc += "-lstdc++"
EXTRA_OECONF = " --with-link-size=2 --enable-newline-is-lf --with-match-limit=10000000 --enable-rebuild-chartables --enable-utf8"

do_compile () {
	# stop libtool from trying to link with host libraries - fix from #33
	# this resolve build problem on amd64 - #1015
	if [ -e ${S}/${TARGET_SYS}-libtool ] ; then
		sed -i 's:-L\$:-L${STAGING_LIBDIR} -L\$:' ${S}/${TARGET_SYS}-libtool
	else
		ln -sf ${S}/libtool ${S}/${TARGET_SYS}-libtool
		sed -i 's:-L\$:-L${STAGING_LIBDIR} -L\$:' ${S}/${TARGET_SYS}-libtool	
	fi

	# The generation of dftables can lead to timestamp problems with ccache
	# because the generated config.h seems newer.  It is sufficient to ensure that the
	# attempt to build dftables inside make will actually work (foo_FOR_BUILD is
	# only used for this).
	oe_runmake CC_FOR_BUILD="${BUILD_CC}" CFLAGS_FOR_BUILD="-DLINK_SIZE=2 -I${S}/include" LINK_FOR_BUILD="${BUILD_CC} -L${S}/lib"
}

do_stage () {
	oe_libinstall -a -so libpcre ${STAGING_LIBDIR}
	oe_libinstall -a -so libpcreposix ${STAGING_LIBDIR}
	install -m 0644 pcre.h ${STAGING_INCDIR}/
	install -m 0644 pcreposix.h ${STAGING_INCDIR}/
        install -d ${STAGING_BINDIR_NATIVE}
	install -m 0755 ${S}/dftables ${STAGING_BINDIR_NATIVE}/
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/*"
