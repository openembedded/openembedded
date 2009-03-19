PR = "r1"

CROSSTOOL_PATCH_URL = "http://www.kegel.com/crosstool/crosstool-0.43/patches/binutils-2.16.1/"
SRC_URI = \
    "${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2 \
     ${CROSSTOOL_PATCH_URL}bfd-hash-tweak.patch;patch=1 \
     ${CROSSTOOL_PATCH_URL}binutils-2.15-psignal.patch;patch=1 \
     ${CROSSTOOL_PATCH_URL}binutils-skip-comments.patch;patch=1 \
     ${CROSSTOOL_PATCH_URL}callahan.patch;patch=1 \
     ${CROSSTOOL_PATCH_URL}cross-gprof.patch;patch=1 \
     ${CROSSTOOL_PATCH_URL}stabs-tweak.patch;patch=1 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1"


require binutils.inc
