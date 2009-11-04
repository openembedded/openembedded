include boost-36.inc

PR = "r7"

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
           file://arm-intrinsics.patch;patch=1 \
           file://01-no-serialization-test.patch;patch=1 \
           file://02-atomic-count-pthreads-on-arm.patch;patch=1 \
           file://03-exception-clone-destructor-fix.patch;patch=1 \
          "

BJAM_OPTS    = '${BJAM_TOOLS} \
                --builddir=${S}/${TARGET_SYS} \
                ${BJAM_EXTRA}'

