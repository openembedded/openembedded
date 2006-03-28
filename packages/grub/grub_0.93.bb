DESCRIPTION = "GRUB is the GRand Unified Bootloader"
SECTION = "base"
HOMEPAGE = "http://www.gnu.org/software/grub"

SRC_URI = "ftp://alpha.gnu.org/gnu/grub/grub-${PV}.tar.gz; \
	   file://autohell.patch;patch=1 \
	   file://memcpy.patch;patch=1 \
	   file://reiserfs.patch;patch=1"

S = "${WORKDIR}/grub-${PV}"

inherit autotools

COMPATIBLE_HOST = 'i.86.*-linux'
