SECTION = "console/utils"
PR = "r1"
DESCRIPTION = "Console utility for generating a SIMpad boot image for the proprietary SIEMENS Switzerland bootloader"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/genboot"
SRC_URI = "file://gen_boot.c file://arnold_boot.h file://simpad-make-flashimg"
LICENSE = "GPL"

DEPENDS = "pad-native"

inherit native

do_compile() {
	cp ${WORKDIR}/*.h ${WORKDIR}/*.c .
	${CC} -I. -o genboot gen_boot.c 
}

do_stage() {
	install -m 0755 genboot ${STAGING_BINDIR}/
	install -m 0755 ${WORKDIR}/simpad-make-flashimg ${STAGING_BINDIR}/
}
