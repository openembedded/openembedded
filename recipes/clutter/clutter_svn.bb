require clutter.inc

DEFAULT_PREFERENCE = "-1"

PV = "0.8.0+svnr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "svn://svn.o-hand.com/repos/clutter/trunk;module=clutter;proto=http \
           file://enable_tests.patch;patch=1;maxrev=2989 \
           file://enable-tests-r2990.patch;patch=1;minrev=2990"

S = "${WORKDIR}/clutter"


