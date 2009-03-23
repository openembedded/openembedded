require flite.inc

PR = "r1"

EXTRA_OECONF = "--with-audio=alsa --enable-shared"

SRC_URI = "http://www.speech.cs.cmu.edu/flite/packed/flite-${PV}/flite-${PV}-release.tar.bz2 \
#          file://fix-read-only-assignments.patch;patch=1 \  # included in the alsa patch
#source    http://homepage.hispeed.ch/loehrer/downloads/flite-1.2-alsa_support-1.2.diff.bz2 \
           file://flite-1.2-alsa_support-1.2.diff;patch=1"
