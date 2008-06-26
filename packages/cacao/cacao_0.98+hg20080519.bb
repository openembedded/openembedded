require cacao.inc

PR = "r1"

SRC_URI = "http://downloads.openmoko.org/sources/cacao-0.98+hg20080519.tar.gz;md5sum=1c6e0530be63ec8a4c0ab2935c2fdc8f \
           file://cacao-${PV}-build-java-runtime-library-classes.patch;patch=1 \ \
          "

S = "${WORKDIR}/cacao"

DEFAULT_PREFERENCE = "-1"
