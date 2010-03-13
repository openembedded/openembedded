include boost-36.inc

DEFAULT_PREFERENCE = "-1"

PR = "${INC_PR}.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2;name=boost1370tarbz2 \
           file://arm-intrinsics.patch;patch=1 \
           file://02-atomic-count-pthreads-on-arm.patch;patch=1 \
           file://uclibc.patch;patch=1 \
           file://sscanf.patch;patch=1 \
          "

SRC_URI[boost1370tarbz2.md5sum] = "8d9f990bfb7e83769fa5f1d6f065bc92"
SRC_URI[boost1370tarbz2.sha256sum] = "d52ef49f70b1b9addc4e0d1a3a2a1966227f0d173c3301bac3e6d399eeac5472"

BJAM_OPTS    = '${BJAM_TOOLS} \
                --builddir=${S}/${TARGET_SYS} \
                ${BJAM_EXTRA}'

