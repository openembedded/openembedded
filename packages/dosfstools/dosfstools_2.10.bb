DESCRIPTION = "DOS FAT Filesystem Utilities"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.uni-erlangen.de/pub/Linux/LOCAL/dosfstools/dosfstools-${PV}.src.tar.gz \
       file://alignment_hack.patch;patch=1 \
	   file://dosfstools-2.10-kernel-2.6.patch;patch=1"

do_install () {
	oe_runmake "PREFIX=${D}" "SBINDIR=${D}${sbindir}" \
		   "MANDIR=${D}${mandir}/man8" install
}
