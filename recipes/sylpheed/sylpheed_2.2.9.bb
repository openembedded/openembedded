SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://sylpheed.good-day.net/sylpheed/v2.2/sylpheed-${PV}.tar.bz2 \
	file://sylpheed-2.2.2-libsylph-Makefile-am.patch;patch=1 \
	file://sylpheed-2.2.2-src-Makefile-am.patch;patch=1 \
	file://sylpheed-gnutls_2.2.4.patch;patch=1"


FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN}-doc += "${datadir}"

EXTRA_OECONF = "--disable-ssl --enable-gnutls"

CFLAGS += "-D_GNU_SOURCE"

do_configure_prepend() {
	mkdir -p m4
}

inherit autotools

do_install_append() {
	install -d ${D}${datadir}/applications
	install -m 0644 sylpheed.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps
	install -m 0644 sylpheed.png ${D}${datadir}/pixmaps/
}


SRC_URI[md5sum] = "45e9e89775613b0afb732fbc11c73d26"
SRC_URI[sha256sum] = "72a6ab7c8a0baf0d1d432929c19a7d096335ba4adc43e40488b6a77e5995a0f5"
