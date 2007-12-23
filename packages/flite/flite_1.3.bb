require flite.inc

PR = "r0"

SRC_URI = "http://www.speech.cs.cmu.edu/flite/packed/flite-${PV}/flite-${PV}-release.tar.gz \
#          http://homepage.hispeed.ch/loehrer/downloads/flite-1.3-alsa_support-1.2.diff.bz2 \
           file://flite-1.3-alsa_support-1.2.diff;patch=1"
#          file://fix-read-only-assignments.patch;patch=1 \
