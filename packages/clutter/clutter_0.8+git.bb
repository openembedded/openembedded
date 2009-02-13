require clutter.inc

CLUTTER_REV = "7129ee4f1b86bfcb65b5fc39021b05b74168785d"

PV = "0.8.7+gitr${CLUTTER_REV}"
PR = "r0"
SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git;branch=clutter-0-8;rev=${CLUTTER_REV} \
           file://enable-tests-r2990.patch;patch=1"

S = "${WORKDIR}/git"



