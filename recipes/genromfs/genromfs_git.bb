require genromfs.inc

SRCREV = "3b02d7a"
PV = "0.0+git${SRCREV}"
PR = "${INC_PR}.0"

SRC_URI = "git://github.com/chexum/genromfs;protocol=git;branch=master"
S = "${WORKDIR}/git"
