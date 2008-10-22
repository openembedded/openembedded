require flite.inc

PR = "r3"

EXTRA_OECONF = "--with-audio=oss --enable-shared"

SRC_URI = "http://www.speech.cs.cmu.edu/flite/packed/flite-${PV}/flite-${PV}-release.tar.gz \
           file://flite-1.3-Makefile.patch;patch=1 \
#          file://flite-1.3-fix-read-only-assignments.patch;patch=1 \  # fixed elsewhere in 1.3 release?
           file://flite-1.3-configure-with-audio.patch;patch=1"
