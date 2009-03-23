DESCRIPTION = "GRUB is the GRand Unified Bootloader"
HOMEPAGE = "http://www.gnu.org/software/grub"
SECTION = "bootloaders"
PRIORITY = "optional"

SRC_URI = "ftp://alpha.gnu.org/gnu/grub/grub-${PV}.tar.gz; \
	   file://autohell.patch;patch=1 \
	   file://memcpy.patch;patch=1 \
	   file://reiserfs.patch;patch=1"

inherit autotools

COMPATIBLE_HOST = 'i.86.*-linux'

FILES_${PN}-doc = "${datadir}"
