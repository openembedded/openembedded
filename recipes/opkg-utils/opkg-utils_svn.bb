DESCRIPTION = "OPKG Package Manager Utilities"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS_${PN} = "python"
RDEPENDS_virtclass_native = ""
SRCREV = "4595"
PV = "0.0+svnr${SRCPV}"
PR = "r4"

BBCLASSEXTEND = "native"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host/;module=opkg-utils;proto=http"

TARGET_CC_ARCH += "${LDFLAGS}"
S = "${WORKDIR}/opkg-utils"

inherit autotools

S = "${WORKDIR}/opkg-utils"
