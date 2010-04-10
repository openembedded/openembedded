require boost-14x.inc

PR = "${INC_PR}.1"

SRC_URI = "http://sodium.resophonic.com/boost-cmake/1.40.0.cmake2/boost-1.40.0.cmake2.tar.gz \
           file://uclibc.patch;patch=1 \
          "
S = "${WORKDIR}/boost-1.40.0.cmake2"

DEFAULT_PREFERENCE = "-1"

SRC_URI[md5sum] = "1a0926fe4c8228f14a2622b4182b801e"
SRC_URI[sha256sum] = "ce6e6c3a6b9a3e7695cb7a0f83d4dbb58f1fb246eb706e3caf3fce3b77e186c0"
