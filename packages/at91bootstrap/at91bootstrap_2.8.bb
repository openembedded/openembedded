DESCRIPTION = "at91bootstrap"
SRC_URI = "ftp://www.at91.com/pub/buildroot/${PN}-${PV}.tar.bz2 \
           "

PR = "r0"
SECTION = "bootloaders"

AT91BOOTSTRAP_MACHINE ?= "${MACHINE}"
AT91BOOTSTRAP_FLAGS ?= ""
AT91BOOTSTRAP_MEMORY ?= "dataflash"
AT91BOOTSTRAP_CARD ?= ""
#AT91BOOTSTRAP_CARD ?= "card"

AT91BOOTSTRAP_IMAGE = "${PN}-${AT91BOOTSTRAP_MACHINE}-${AT91BOOTSTRAP_MEMORY}-${PV}-${PR}.bin"
AT91BOOTSTRAP_BUILD_IMAGE = "${S}/binaries/${AT91BOOTSTRAP_MACHINE}-${AT91BOOTSTRAP_MEMORY}${AT91BOOTSTRAP_CARD}boot-${PV}.bin"
AT91BOOTSTRAP_SYMLINK = "${PN}.bin"

S = "${WORKDIR}/${PN}-${PV}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} MEMORY=${AT91BOOTSTRAP_MEMORY}"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS

	rm -Rf ${S}/binaries
	oe_runmake ${AT91BOOTSTRAP_MACHINE}_defconfig
	sed 
	oe_runmake AT91_CUSTOM_FLAGS="${AT91BOOTSTRAP_FLAGS}"
	chmod +x ${S}/fixboot.py
	${S}/fixboot.py $(AT91BOOTSTRAP_BUILD_IMAGE)
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install $(AT91BOOTSTRAP_BUILD_IMAGE).fixboot \
		${DEPLOY_DIR_IMAGE}/${AT91BOOTSTRAP_IMAGE}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${AT91BOOTSTRAP_IMAGE}
	cd ${DEPLOY_DIR_IMAGE}
	rm -f ${AT91BOOTSTRAP_SYMLINK}
	ln -sf ${AT91BOOTSTRAP_IMAGE} ${AT91BOOTSTRAP_SYMLINK}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${AT91BOOTSTRAP_SYMLINK}
}

do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
