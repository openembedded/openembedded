SECTION = "x11/network"
DESCRIPTION = "Mail user agent"
DEPENDS = "gtk+ libetpan openssl aspell"
LICENSE = "GPL"
PR = "r3"

inherit autotools pkgconfig

# translation patch: http://www.thewildbeast.co.uk/claws-mail/bugzilla/show_bug.cgi?id=1774
SRC_URI = "\
	${SOURCEFORGE_MIRROR}/sylpheed-claws/claws-mail-${PV}.tar.bz2;name=archive \
	http://www.penguin.cz/~utx/ftp/claws-mail/claws-mail-${PV}-po-update.patch;patch=1;name=patch \
	file://desktop.patch;patch=1 \
	file://claws-mail-g_strcmp0.patch;patch=1 \
	file://duplicate-header.patch;patch=1 \
	"

do_configure_append() {
	cd po ; for PO in *.po ; do MO=`echo $PO | sed s/\\.po//`.gmo ; if ! test -f $MO ; then msgfmt $PO -o $MO ; fi ; done
}

# FIXME: maemo builds may want --enable-maemo
# FIXME: some platforms may want --enable-generic-umpc
EXTRA_OECONF = "--disable-aspell-test 		\
		--enable-aspell 		\
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

# Remove enchant references:
do_install_prepend() {
	sed -i -e 's:${STAGING_INCDIR}:${includedir}:g;s:${STAGING_LIBDIR}:${libdir}:g' claws-mail.pc
}

# Work-around broken GPE icon lookup:
do_install_append() {
	rm -r ${D}${datadir}/icons
	install -d ${D}${datadir}/pixmaps
	install -m 0644 claws-mail.png ${D}${datadir}/pixmaps/
	sed -i 's/Icon=[^.]*$/&.png/' ${D}${datadir}/applications/claws-mail.desktop
}


SRC_URI[archive.md5sum] = "761b8ae2d574588460a0fb1ea4931ccb"
SRC_URI[archive.sha256sum] = "67337a4a1a5a5ce09f2a38422b7a6fc481e4747f74d4ddedd130d4fb06fc3907"
SRC_URI[patch.md5sum] = "e8ff3fabf1ed47f3b11a9cdc36b026bd"
SRC_URI[patch.sha256sum] = "767258dd7c966e14ed519affe4c0da93e8fff66ee5fe9158413c8d163af72db8"
