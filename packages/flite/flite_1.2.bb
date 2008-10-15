require flite.inc

PR = "r5"

EXTRA_OECONF = "--with-audio=oss --enable-shared"

SRC_URI = "http://www.speech.cs.cmu.edu/flite/packed/flite-${PV}/flite-${PV}-release.tar.bz2 \
           file://fix-read-only-assignments.patch;patch=1 \
           file://configure-with-audio.patch;patch=1"
