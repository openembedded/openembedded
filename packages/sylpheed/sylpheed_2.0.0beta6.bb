SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"
LICENSE = "GPL"
PR = "r3"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://sylpheed.good-day.net/sylpheed/v2.0beta/sylpheed-2.0.0beta6.tar.bz2 \
	file://sylpheed-gnutls_2.0.0beta6.patch;patch=1 \
	file://sylpheed-gnutls-extra.patch;patch=1 "

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

