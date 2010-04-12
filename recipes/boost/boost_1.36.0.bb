include boost-36.inc

PR = "${INC_PR}.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
           file://arm-intrinsics.patch;patch=1 \
           file://01-no-serialization-test.patch;patch=1 \
           file://02-atomic-count-pthreads-on-arm.patch;patch=1 \
           file://03-exception-clone-destructor-fix.patch;patch=1 \
           file://gcc-44.diff;patch=1 \
           file://uclibc.patch;patch=1 \
           file://sscanf.patch;patch=1 \
          "

BJAM_OPTS    = '${BJAM_TOOLS} \
                --builddir=${S}/${TARGET_SYS} \
                ${BJAM_EXTRA}'


SRC_URI[md5sum] = "328bfec66c312150e4c2a78dcecb504b"
SRC_URI[sha256sum] = "9a4a0cfbbd227c20a13519a2c41f2e707dc0d89e518a3c7bfcd381f7b7fbcdef"
