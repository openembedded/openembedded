# cdparanoia OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)
LICENSE = "GPL"
PV = "10.2+svnr${SRCPV}"
PR = "r2"

SRC_URI = "svn://svn.xiph.org/trunk;module=cdparanoia;proto=http \
         file://fixes10.patch \
         file://Makefile.in.patch \
         file://interface_Makefile.in.patch \
         file://paranoia_Makefile.in.patch \
         file://configure.in.patch "

SRCREV = "16684"
S = "${WORKDIR}/cdparanoia"

inherit autotools

do_install() {
        oe_runmake BINDIR="${D}/usr/bin" MANDIR="${D}/usr/share/man/" \
                   INCLUDEDIR="${D}/usr/include/" LIBDIR="${D}/usr/lib" install
}

PARALLEL_MAKE = ""
