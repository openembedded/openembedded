SECTION = "libs"
DESCRIPTION = "Session Initiation Protocol (SIP) library"
LEAD_SONAME = "libosip2\..*"
PR = "r0"
LICENSE = "LGPL"
SRC_URI = "${GNU_MIRROR}/osip/libosip2-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}

SRC_URI[md5sum] = "7eb305608256ac2a7a27b66ce52627c8"
SRC_URI[sha256sum] = "245911a9a48bbe868c4518faf86191f6568fb99d9967d368164a17a83671e8fb"
