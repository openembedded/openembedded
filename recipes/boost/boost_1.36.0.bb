include boost-36.inc

PR = "${INC_PR}.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
           file://arm-intrinsics.patch \
           file://01-no-serialization-test.patch \
           file://02-atomic-count-pthreads-on-arm.patch \
           file://03-exception-clone-destructor-fix.patch \
           file://gcc-44.diff \
           file://uclibc.patch \
           file://sscanf.patch \
          "

BJAM_OPTS    = '${BJAM_TOOLS} \
                --builddir=${S}/${TARGET_SYS} \
                ${BJAM_EXTRA}'


SRC_URI[md5sum] = "328bfec66c312150e4c2a78dcecb504b"
SRC_URI[sha256sum] = "9a4a0cfbbd227c20a13519a2c41f2e707dc0d89e518a3c7bfcd381f7b7fbcdef"
