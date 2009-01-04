require clutter.inc

CLUTTER_REV = "3597"

PV = "0.8.4+svnr${CLUTTER_REV}"
PR = "r0"
SRC_URI = "svn://svn.o-hand.com/repos/clutter/branches;module=clutter-0-8;proto=http;rev=${CLUTTER_REV} \
           file://enable_tests.patch;patch=1;maxrev=2989 \
           file://enable-tests-r2990.patch;patch=1;minrev=2990"

S = "${WORKDIR}/clutter-0-8"



