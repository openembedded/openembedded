SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme gnutls libetpan"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sylpheed-claws/sylpheed-claws-2.2.0.tar.bz2"


FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"

EXTRA_OECONF = "--disable-aspell"

CFLAGS += "-D_GNU_SOURCE"

do_configure_prepend() {
	mkdir -p m4
}

inherit autotools 

do_install_append() {
	install -d ${D}${datadir}/applications
	install -m 0644 sylpheed-claws.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps
	install -m 0644 sylpheed-claws.png ${D}${datadir}/pixmaps/
}

