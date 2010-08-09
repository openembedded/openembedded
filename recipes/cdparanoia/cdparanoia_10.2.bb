# cdparanoia OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
LICENSE = "GPL"

SRC_URI = "http://downloads.xiph.org/releases/cdparanoia/cdparanoia-III-10.2.src.tgz \
         file://fixes10.patch \
         file://Makefile.in.patch \
         file://interface_Makefile.in.patch \
         file://paranoia_Makefile.in.patch \
         file://cdparanoia-III-10.2-privatefix.patch \
         file://configure.in.patch"
SRC_URI[md5sum] = "b304bbe8ab63373924a744eac9ebc652"
SRC_URI[sha256sum] = "005db45ef4ee017f5c32ec124f913a0546e77014266c6a1c50df902a55fe64df"

S = "${WORKDIR}/cdparanoia-III-10.2"

inherit autotools

do_install() {
        oe_runmake BINDIR="${D}/usr/bin" MANDIR="${D}/usr/share/man/" \
                   INCLUDEDIR="${D}/usr/include/" LIBDIR="${D}/usr/lib" install
}

PARALLEL_MAKE = ""
