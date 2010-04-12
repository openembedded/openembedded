require flite.inc

PR = "r1"

EXTRA_OECONF = "--with-audio=alsa --enable-shared"

SRC_URI = "http://www.speech.cs.cmu.edu/flite/packed/flite-${PV}/flite-${PV}-release.tar.bz2 \
#          file://fix-read-only-assignments.patch;patch=1 \  # included in the alsa patch
#source    http://homepage.hispeed.ch/loehrer/downloads/flite-1.2-alsa_support-1.2.diff.bz2 \
           file://flite-1.2-alsa_support-1.2.diff;patch=1"

SRC_URI[md5sum] = "24c1576f5b3eb23ecedf4bebde96710f"
SRC_URI[sha256sum] = "10ff42ce08a628c7fd84d26b5228d549e9eecb1eb03cb158e87d8be66bc58ae2"
