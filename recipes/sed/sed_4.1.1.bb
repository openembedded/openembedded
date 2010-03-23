LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."
PR = "r1"

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz"
S = "${WORKDIR}/sed-${PV}"

inherit autotools

BBCLASSEXTEND = "native"
