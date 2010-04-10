LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."
PR = "r1"

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz"
S = "${WORKDIR}/sed-${PV}"

inherit autotools

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "570c0a53a64ec020d8fcbce51fb6d71a"
SRC_URI[sha256sum] = "5e0bec79ff46ad189370e9defc95f72bd255990bfc3ad546e64f41eb08533fd9"
