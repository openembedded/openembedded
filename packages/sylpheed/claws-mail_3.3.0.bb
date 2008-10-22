SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ libetpan openssl aspell"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/sylpheed-claws/claws-mail-${PV}.tar.bz2	\
	file://desktop.patch;patch=1				\
	"

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"

EXTRA_OECONF = "--disable-aspell-test 		\
		--enable--aspell 		\
		--disable-manual		\
		--disable-crash-dialog		\
		--disable-jpilot		\
		--disable-trayicon-plugin	\
		--disable-spamassassin-plugin	\
		--disable-bogofilter-plugin	\
		--disable-pgpcore-plugin	\
		--disable-pgpmime-plugin	\
		--disable-pgpinline-plugin	\
  		--disable-dillo-viewer-plugin	\
		--disable-clamav-plugin		\
		--disable-gnomeprint		\
		--disable-valgrind		\
		"

inherit autotools pkgconfig

do_install_append() {
	install -d ${D}${datadir}/applications
	install -m 0644 claws-mail.desktop ${D}${datadir}/applications/
	install -d ${D}${datadir}/pixmaps
	install -m 0644 claws-mail.png ${D}${datadir}/pixmaps/
}

do_stage () {
	autotools_stage_all
}

