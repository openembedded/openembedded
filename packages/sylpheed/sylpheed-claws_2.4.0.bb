SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme libetpan libgnomeprint aspell"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sylpheed-claws/sylpheed-claws-${PV}.tar.bz2"


FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"

EXTRA_OECONF = "--disable-aspell --disable-openssl --disable-aspell-test \
 --disable-dillo-viewer-plugin --with-aspell-prefix=${STAGING_DIR}/${HOST_SYS} \
 --enable-aspell"

CFLAGS += "-D_GNU_SOURCE"

do_configure_prepend() {
	mkdir -p m4
}

inherit autotools pkgconfig

do_install_append() {
	install -d ${D}${datadir}/applications
	install -m 0644 sylpheed-claws.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps
	install -m 0644 sylpheed-claws.png ${D}${datadir}/pixmaps/
}

do_stage () {
	autotools_stage_all
}

