# Overrides for a CVS build
include upslug2.inc

SRC_TAG = "upslug2_${@'_'.join(bb.data.getVar('PV',d,1).split('.'))}"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/nslu;method=pserver;module=upslug2;tag=${SRC_TAG}"
# For testing use this (tags and other changes take a day to
# propogate on sourceforge).  Change 'jbowler' to your login name!
#SRC_URI = "cvs://jbowler@cvs.sourceforge.net/cvsroot/nslu;method=ext;rsh=ssh;module=upslug2;tag=${SRC_TAG}"

S = "${WORKDIR}/upslug2"
