DESCRIPTION = "Console utility for generating a SIMpad boot image for the proprietary SIEMENS Switzerland bootloader"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "pad-native"
PR = "r2"

SRC_URI = "file://gen_boot.c file://arnold_boot.h file://simpad-make-flashimg"

inherit native

do_compile() {
        cp ${WORKDIR}/*.h ${WORKDIR}/*.c .
        ${CC} -I. -o genboot gen_boot.c
}
do_install() {
        install -d ${D}${bindir}/
        install -m 0755 genboot ${D}${bindir}/
        install -m 0755 ${WORKDIR}/simpad-make-flashimg ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"
