require libvalhalla.inc
PV = "1.0.1+hg"
PR = "${INC_PR}.0"

SRCREV = "a12610802732"

SRC_URI = "hg://hg.geexbox.org;module=${PN};rev=${SRCREV}"

S = "${WORKDIR}/${PN}"
