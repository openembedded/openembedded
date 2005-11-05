DESCRIPTION = "A GNet Client for Qtopia/Opie based Palmtop Environments"
SECTION = "opie"
PRIORITY = "optional"
MAINTAINER = "Michael Lauer <mickey@Vanille.de>"

SRC_URI = "${SOURCEFORGE_MIRROR}/qtella/qtella-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-qt-dir=${STAGING_LIBDIR}/.. --with-qt-moc=${STAGING_BINDIR}/moc --with-qt-uic=${STAGING_BINDIR}/uic \
		--with-qt-includes=${STAGING_INCDIR}/ --with-qt-libs=${STAGING_LIBDIR}/ --with-kde=no --enable-sharp"

