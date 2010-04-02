require libplayer.inc
PV = "1.0.0+hg"
PR = "${INC_PR}.1"

SRCREV = "4fb30e64db79"

SRC_URI = "hg://hg.geexbox.org;module=${PN};rev=${SRCREV}"

S = "${WORKDIR}/${PN}"
