require clutter.inc

CLUTTER_REV = "af16378899699376fe7e84c7c11eb3bb5c4668cd"

PV = "0.8.8"
PR = "${INC_PR}.0"
PR_append = "+gitr${CLUTTER_REV}"

SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git;branch=clutter-0-8;rev=${CLUTTER_REV} \
           file://enable-tests-r2990.patch;patch=1"

S = "${WORKDIR}/git"



