require libsvdrp.inc
PV = "0.0.1+hg"
PR = "${INC_PR}.0"

SRCREV = "0b191f7b2cb8"

SRC_URI = "hg://hg.geexbox.org;module=${PN};rev=${SRCREV}"

S = "${WORKDIR}/${PN}"
