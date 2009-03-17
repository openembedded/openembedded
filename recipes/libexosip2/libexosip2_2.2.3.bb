DESCRIPTION = "High level Session Initiation Protocol (SIP) library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libosip2"
SRCNAME = "libeXosip2"
LEAD_SONAME = "libeXosip2"

PR = "r0"
SRC_URI = "http://download.savannah.nongnu.org/releases/exosip/${SRCNAME}-${PV}.tar.gz \
           file://simplify-flags.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig
EXTRA_OECONF = "--disable-josua"

do_stage() {
        autotools_stage_all
}
