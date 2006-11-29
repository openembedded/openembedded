DESCRIPTION = "A GNet Client for Qtopia/Opie based Palmtop Environments"
SECTION = "opie"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/qtella/qtella-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-qt-dir=${STAGING_LIBDIR}/.. --with-qt-moc=${STAGING_BINDIR_NATIVE}/moc --with-qt-uic=${STAGING_BINDIR_NATIVE}/uic \
		--with-qt-includes=${STAGING_INCDIR}/ --with-qt-libs=${STAGING_LIBDIR}/ --with-kde=no --enable-sharp"

