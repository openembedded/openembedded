# Copyright (C) 2009 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Event device test program"
AUTHOR = "Vojtech Pavlik <vojtech@suse.cz>"
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "http://beagleboard.googlecode.com/files/evtest.c"
S = "${WORKDIR}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
    ${CC} evtest.c -o evtest -I${STAGING_INCDIR} -L${STAGING_LIBDIR}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 evtest ${D}${bindir}
}
