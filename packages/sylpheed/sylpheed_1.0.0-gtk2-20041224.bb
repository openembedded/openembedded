SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/sylpheed-gtk2/sylpheed-${PV}.tar.gz \
	file://sylpheed-gnutls.patch;patch=1"

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN}-doc += "${datadir}"

EXTRA_OECONF = "--with-gnutls"

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

