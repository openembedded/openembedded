SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ gpgme libetpan libgnomeprint aspell"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sylpheed-claws/claws-mail-${PV}.tar.bz2"

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"

EXTRA_OECONF = "--disable-openssl --disable-aspell-test \
 --disable-dillo-viewer-plugin --with-aspell-prefix=${STAGING_DIR}/${HOST_SYS} \
 --enable-aspell"

CFLAGS += "-D_GNU_SOURCE"

inherit autotools pkgconfig

do_configure() {
    gnu-configize
    libtoolize --force
    oe_runconf
}

do_install_append() {
	install -d ${D}${datadir}/applications
	install -m 0644 claws-mail.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps
	install -m 0644 claws-mail.png ${D}${datadir}/pixmaps/
	mv ${D}${bindir}/${TARGET_SYS}-claws-mail ${D}${bindir}/${PN}
}

do_stage () {
	autotools_stage_all
}

python populate_packages_prepend () {
	abiword_libdir = bb.data.expand('${libdir}/claws-mail/plugins', d)

	do_split_packages(d, abiword_libdir, '^(.*)\.so$', 'claws-mail-plugin-%s', 'Claws plugin for %s', extra_depends='')
}
