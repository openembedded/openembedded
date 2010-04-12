LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz"
S = "${WORKDIR}/sed-${PV}"

inherit autotools

SRC_URI[md5sum] = "d8fb554bc6577aaedd39b94b3cb3df70"
SRC_URI[sha256sum] = "c365874794187f8444e5d22998cd5888ffa47f36def4b77517a808dec27c0600"
