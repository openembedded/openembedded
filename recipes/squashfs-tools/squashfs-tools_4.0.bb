require squashfs-tools.inc
DEPENDS += "lzma"
PR = "${INC_PR}.1"

EXTRA_OEMAKE = "USE_LZMA=1 \
                LZMA_CFLAGS='-I${STAGING_INCDIR}/lzma -DUSE_LZMA' \
                LZMA_LIB='${STAGING_LIBDIR}/liblzma.a'"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI += " file://portability.patch;patch=1;pnum=2 \
             file://lzma-support.patch;patch=1;pnum=2"

