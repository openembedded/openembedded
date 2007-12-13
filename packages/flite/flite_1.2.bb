require flite.inc

PR = "r3"

SRC_URI = "http://www.speech.cs.cmu.edu/flite/packed/flite-${PV}/flite-${PV}-release.tar.bz2 \
#          http://homepage.hispeed.ch/loehrer/downloads/flite-1.2-alsa_support-1.2.diff.bz2 \
           file://flite-1.2-alsa_support-1.2.diff;patch=1"
#          file://configure-with-audio.patch;patch=1 \
