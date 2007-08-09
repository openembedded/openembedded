DESCRIPTION = "The 'Open Free Fiasco Firmware Flasher' aka 0xFFFF utility aims to implement a free (GPL'd) userspace handler for the NOLO bootloader."
LICENSE = "GPLv3"

SRC_URI = "http://www.nopcode.org/0xFFFF/get/0xFFFF-${PV}.tar.gz"

S = "${WORKDIR}/0xFFFF-${PV}/src"

CFLAGS += '-DVERSION="${PV}" -I.'
BUILD_CFLAGS += '-DVERSION="${PV}" -I.'

do_compile() {
       oe_runmake 
}

