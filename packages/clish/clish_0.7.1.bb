DESCRIPTION = "modular framework for implementing a CISCO-like CLI on a *NIX system"
LICENSE = "GPL"
SECTION = "console/utils"
PR="r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/clish/clish-0.7.1.tar.gz"

S = "${WORKDIR}/clish-${PV}"

inherit autotools


LEAD_SONAME="libclish.so.*"
