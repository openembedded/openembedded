LICENSE = GPL
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz \
	   file://fchmod.patch;patch=1"
S = "${WORKDIR}/sed-${PV}"

inherit autotools
