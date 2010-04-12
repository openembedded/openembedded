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

SRC_URI[md5sum] = "da26fda6df8835a7cb95182e1fabe912"
SRC_URI[sha256sum] = "ba2bdf6887eb0ef606402d51a2f4e68510d68dec5afd9f4d30d787950dece770"
