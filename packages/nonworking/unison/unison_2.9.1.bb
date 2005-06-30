DESCRIPTION=Unison is a file-synchronization tool for Unix and Windows.
SECTION=net
PRIORITY=optional

SRC_URI = ${DEBIAN_MIRROR}/main/u/${PN}/${PN}_${PV}.orig.tar.gz \
          file://${FILESDIR}/debian.patch;patch=1
