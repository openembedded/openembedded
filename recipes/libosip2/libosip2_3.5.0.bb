SECTION = "libs"
DESCRIPTION = "Session Initiation Protocol (SIP) library"
LEAD_SONAME = "libosip2\..*"
PR = "r0"
LICENSE = "LGPL"
SRC_URI = "${GNU_MIRROR}/osip/libosip2-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "7691546f6b3349d10007fc1aaff0f4e0"
SRC_URI[sha256sum] = "dd955daa24d9ce2de6709b8c13e7c04ebc3afa8ac094d6a15a02a075be719a91"
