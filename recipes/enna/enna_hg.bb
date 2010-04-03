require enna.inc
PV = "0.4.0+hg"
PR = "${INC_PR}.0"

SRCREV = "2a9c5f249b47"

SRC_URI = "hg://hg.geexbox.org;proto=http;module=${PN};rev=${SRCREV}"

S = "${WORKDIR}/${PN}"
