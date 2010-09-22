DESCRIPTION = "at91bootstrap: loaded into internal SRAM by AT91 BootROM"
SECTION = "bootloaders"

COMPATIBLE_MACHINE = "(afeb9260|at91cap9adk|at91sam9g20ek|at91sam9rlek|at91sam9263ek|at91sam9260ek|at91sam9xeek|at91sam9261ek)"
SRC_URI = "ftp://www.at91.com/pub/buildroot/${PN}-${PV}.tar.bz2 \
	   file://defconfig \
           "
S = "${WORKDIR}/${PN}-${PV}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} DESTDIR=${DEPLOY_DIR_IMAGE} REVISION=${PR}"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS

	rm -Rf ${S}/binaries
	cp ${S}/../defconfig ${S}/.config
	oe_runmake AT91_CUSTOM_FLAGS="${AT91BOOTSTRAP_FLAGS}"
	oe_runmake AT91_CUSTOM_FLAGS="${AT91BOOTSTRAP_FLAGS}" boot
	oe_runmake AT91_CUSTOM_FLAGS="${AT91BOOTSTRAP_FLAGS}" install
}
