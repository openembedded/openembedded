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
