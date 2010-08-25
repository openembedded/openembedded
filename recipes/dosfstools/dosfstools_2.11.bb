# dosfstools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "DOS FAT Filesystem Utilities"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "ftp://ftp.uni-erlangen.de/pub/Linux/LOCAL/dosfstools/dosfstools-${PV}.src.tar.gz \
           file://alignment_hack.patch \
           file://msdos_fat12_undefined.patch \
           file://include-linux-types.patch"
SRC_URI[md5sum] = "407d405ade410f7597d364ab5dc8c9f6"
SRC_URI[sha256sum] = "0eac6d12388b3d9ed78684529c1b0d9346fa2abbe406c4d4a3eb5a023c98a484"

CFLAGS_append = " -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64"
CFLAGS_append_libc-uclibc = ' ${@base_contains("DISTRO_FEATURES", "largefile", "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64", "", d)}'

do_install () {
        oe_runmake "PREFIX=${D}" "SBINDIR=${D}${sbindir}" \
                   "MANDIR=${D}${mandir}/man8" install
}

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"
