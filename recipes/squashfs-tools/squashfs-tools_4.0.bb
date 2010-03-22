# This override is required since this has not yet been released
SRC_URI  = "cvs://anonymous@squashfs.cvs.sourceforge.net/cvsroot/squashfs;module=squashfs;date=${SRCDATE} \
            http://downloads.sourceforge.net/sevenzip/lzma465.tar.bz2"
SRC_URI += " file://Makefile.patch;patch=1"

require squashfs-tools.inc
PR = "${INC_PR}.3"

S = "${WORKDIR}/squashfs/squashfs-tools"

EXTRA_OEMAKE += "LZMA_SUPPORT=1 LZMA_DIR=../.."
TARGET_CC_ARCH += "${LDFLAGS}"

# the COMP_DEFAULT macro should result in a string including quotes: "gzip"
COMP_DEFAULT = gzip
CFLAGS_append = ' -I. -I../../C -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE \
 -D_GNU_SOURCE -DLZMA_SUPPORT -DCOMP_DEFAULT=\\"${COMP_DEFAULT}\\" '
