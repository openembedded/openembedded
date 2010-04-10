LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz"
S = "${WORKDIR}/sed-${PV}"

inherit autotools

SRC_URI[md5sum] = "fb7fa2a7336afc358012763b292e2124"
SRC_URI[sha256sum] = "a02d8c006bc0531bd646cae3082b7db8c7a1969084411cb129ec105fd12c0a13"
