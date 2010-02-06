require boost-14x.inc

PR = "${INC_PR}.1"

SRC_URI = "http://sodium.resophonic.com/boost-cmake/1.40.0.cmake2/boost-1.40.0.cmake2.tar.gz \
           file://uclibc.patch;patch=1 \
          "
S = "${WORKDIR}/boost-1.40.0.cmake2"

DEFAULT_PREFERENCE = "-1"
