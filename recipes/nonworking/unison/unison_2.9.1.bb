DESCRIPTION = "Unison is a file-synchronization tool for Unix and Windows."
SECTION = "net"
PRIORITY = "optional"

SRC_URI = "${DEBIAN_MIRROR}/main/u/${PN}/${PN}_${PV}.orig.tar.gz \
           file://${FILESDIR}/debian.patch;patch=1"

SRC_URI[md5sum] = "d8084fa87c13671de21ec1b701a4606c"
SRC_URI[sha256sum] = "42420dcea33d337cb9859d7f51d76ec5a1cf48f7f8b24b1b820c969248a270a6"
