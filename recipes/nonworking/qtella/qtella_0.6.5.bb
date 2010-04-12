DESCRIPTION = "A GNet Client for Qtopia/Opie based Palmtop Environments"
SECTION = "opie"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/qtella/qtella-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-qt-dir=${STAGING_LIBDIR}/.. --with-qt-moc=${STAGING_BINDIR_NATIVE}/moc --with-qt-uic=${STAGING_BINDIR_NATIVE}/uic \
		--with-qt-includes=${STAGING_INCDIR}/ --with-qt-libs=${STAGING_LIBDIR}/ --with-kde=no --enable-sharp"


SRC_URI[md5sum] = "210e5f014e348815d5b32cd26b605d9c"
SRC_URI[sha256sum] = "0505bed70fca7137753c4650ed03981d56caacbf4e1bee773427999c2c1e4da5"
