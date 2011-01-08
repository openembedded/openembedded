# dosfstools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "DOS FAT Filesystem Utilities"

SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPLv3"

DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "http://www.daniel-baumann.ch/software/dosfstools/dosfstools-${PV}.tar.bz2 \
	"
# output of getconf LFS_CFLAGS
#
CFLAGS_append = ' -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64'
CFLAGS_append_libc-uclibc = ' ${@base_contains("DISTRO_FEATURES", "largefile", "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64", "", d)}'

do_install () {
	oe_runmake "PREFIX=${D}" "SBINDIR=${D}${sbindir}" \
		   "MANDIR=${D}${mandir}/man8" install
}

SRC_URI[md5sum] = "8d2211d5bd813164e20740e7c852aa06"
SRC_URI[sha256sum] = "94b27a0f53f4aa86b0c049eb26df7a681ec6c31bc352c57d3ac53881bcfcd9a8"
