DESCRIPTION = "High level Session Initiation Protocol (SIP) library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libosip2"
SRCNAME = "libeXosip2"
LEAD_SONAME = "libeXosip2"

PR = "r0"
SRC_URI = "http://download.savannah.nongnu.org/releases/exosip/${SRCNAME}-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig
EXTRA_OECONF = "--disable-josua"

do_stage() {
        autotools_stage_all
}

SRC_URI[md5sum] = "ed6005a146501a5f9308e28108ae7bca"
SRC_URI[sha256sum] = "eed72871201e2c1deae3d7c0b618bf16f306d91fc7ebcb53956ab7468663514f"
