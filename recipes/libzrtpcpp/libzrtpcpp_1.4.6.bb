DESCRIPTION = "GNU ZRTP C++"
HOMEPAGE = "http://www.gnutelephony.org/index.php/GNU_ZRTP"
LICENSE = "GPL"
DEPENDS = "ccrtp"

SRC_URI = "http://www.gnutelephony.org/dist/tarballs/libzrtpcpp-${PV}.tar.gz"
SRC_URI[md5sum] = "83157d4eba394d27b06b7ec753fe31de"
SRC_URI[sha256sum] = "1ea5ce5a283095a7bf2fe491a8a7571ef21b3dbe6cf815d3df76e6de1e811dba"

inherit pkgconfig autotools_stage
