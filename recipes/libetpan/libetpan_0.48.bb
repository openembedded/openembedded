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

SRC_URI[md5sum] = "493de1bfc84c1e0f82fd865795e48ffb"
SRC_URI[sha256sum] = "039861766d330b8ff2309334feb97d384e16d927dd859fdc0fad4c4a13d66b7c"
