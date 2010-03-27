require libplayer.inc
PV = "1.0.0+hg"
PR = "${INC_PR}.0"

SRCREV = "a628f49d952a"

SRC_URI = "hg://hg.geexbox.org;module=${PN};rev=${SRCREV}"

S = "${WORKDIR}/${PN}"
