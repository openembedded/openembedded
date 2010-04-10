DESCRIPTION = "libetpan is a library for communicating with mail and news servers. \
It supports the protocols SMTP, POP3, IMAP and NNTP."
HOMEPAGE = "http://www.etpan.org"
SECTION = "libs"
DEPENDS = "gnutls"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/libetpan/libetpan-${PV}.tar.gz \
           file://honor-oe-lflags.patch;patch=1"

inherit autotools pkgconfig gettext binconfig

EXTRA_OECONF = "--without-openssl --with-gnutls --disable-db"

PARALLEL_MAKE = ""

do_stage() {
	autotools_stage_all
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${bindir} ${includedir} ${libdir}/lib*.so ${libdir}/*.la ${libdir}/*.a ${libdir}/pkgconfig"

SRC_URI[md5sum] = "afa4abd73665e1a46b0510c4f4efa9a9"
SRC_URI[sha256sum] = "74c81e8c29de3fda2e196ce7082a5ec35aad9399a6c7f67bb906b3c9d91dc6f3"
