require libnfo.inc
PV = "1.0.0+hg"
PR = "${INC_PR}.0"

SRCREV = "8f6237741f72"

SRC_URI = "hg://hg.geexbox.org;module=${PN};rev=${SRCREV}"

S = "${WORKDIR}/${PN}"
