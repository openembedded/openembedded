require boost-14x.inc

PR = "${INC_PR}.1"

SRC_URI = "http://sodium.resophonic.com/boost-cmake/1.41.0.cmake0/boost-1.41.0.cmake0.tar.gz;name=tarball \
           file://1.41.0_uclibc.patch;patch=1 \
          "
S = "${WORKDIR}/boost-1.41.0.cmake0"

SRC_URI[tarball.md5sum] = "351747d991e3e391fea5623d4b5c038a"
SRC_URI[tarball.sha256sum] = "78b7e72d34b057847ff99b291719d5bf1b76ed080bebfa3122549c231cc8fbed"

DEPENDS += " icu "

DEFAULT_PREFERENCE = "-1"

