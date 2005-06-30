SECTION = "base"
DESCRIPTION = "grand unified bootloader"

SRC_URI = "ftp://alpha.gnu.org/gnu/grub/grub-${PV}.tar.gz; \
	   file://autohell.patch;patch=1 \
	   file://memcpy.patch;patch=1 \
	   file://reiserfs.patch;patch=1"

S = "${WORKDIR}/grub-${PV}"

inherit autotools

python __anonymous () {
	import re
	host = bb.data.getVar('HOST_SYS', d, 1)
	if not re.match('i.86.*-linux', host):
		raise bb.parse.SkipPackage("incompatible with host %s" % host)
}
