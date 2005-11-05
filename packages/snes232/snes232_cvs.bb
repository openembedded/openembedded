SECTION = "unknown"
PR = "r4"
LICENSE = "GPL"
INHIBIT_PACKAGE_STRIP = "1"

RRECOMMENDS = "kernel-module-serport"

SRC_URI = "${HANDHELDS_CVS};module=gpe/games/snes232 \
	file://snes232-2.6.patch;patch=1;pnum=0 \
	file://Makefile-2.6"

S = "${WORKDIR}/snes232"

inherit module

do_configure() {
	install -m 0644 ${WORKDIR}/Makefile-2.6 Makefile
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/snes232
	install snes232.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/snes232/
}
