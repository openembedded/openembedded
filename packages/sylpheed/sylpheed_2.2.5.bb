SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
LICENSE = "GPL"
PR = "r5"

SRC_URI = "http://sylpheed.good-day.net/sylpheed/v2.2/sylpheed-${PV}.tar.bz2 \
	file://sylpheed-2.2.2-libsylph-Makefile-am.patch;patch=1 \
	file://sylpheed-2.2.2-src-Makefile-am.patch;patch=1 \
	file://sylpheed-gnutls_2.2.4.patch;patch=1"


FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN}-doc += "${datadir}"

EXTRA_OECONF = "--enable-gnutls"

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

