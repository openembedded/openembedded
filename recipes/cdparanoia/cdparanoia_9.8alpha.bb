# cdparanoia OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://downloads.xiph.org/releases/cdparanoia/cdparanoia-III-alpha9.8.src.tgz \
         file://fixes.patch \
         file://Makefile.patch"
SRC_URI[md5sum] = "7218e778b5970a86c958e597f952f193"
SRC_URI[sha256sum] = "1b79fae1aedc692f87d1344410f5c6b666961afccdc78bc5c4c257c450dfa008"

S = "${WORKDIR}/cdparanoia-III-alpha9.8"

inherit autotools

do_install() {
        oe_runmake BINDIR="${D}/usr/bin" MANDIR="${D}/usr/share/man/" \
                   INCLUDEDIR="${D}/usr/include/" LIBDIR="${D}/usr/lib" install
}

PARALLEL_MAKE = ""
