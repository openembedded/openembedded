DESCRIPTION = "libetpan is a library for communicating with mail and news servers using \
SMTP, POP, IMAP and NNTP"
SECTION = "libs"
DEPENDS = "gnutls"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/libetpan/libetpan-${PV}.tar.gz \
          file://etpan_suffix.patch;patch=1 "

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--without-openssl --with-gnutls --disable-db --disable-threads"

do_stage () {
	oe_runmake install includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} bindir=${STAGING_BINDIR}
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${bindir} ${includedir} ${libdir}/lib*.so ${libdir}/*.la ${libdir}/*.a ${libdir}/pkgconfig"
