DESCRIPTION = "x-load bootloader loader"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPLv2+"

DEPENDS = "signgp-native"

PARALLEL_MAKE=""

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

XLOAD_MACHINE ?= "${MACHINE}_config"

XLOAD_IMAGE ?= "x-load-${MACHINE}-${PV}-${PR}.bin.ift"
XLOAD_SYMLINK ?= "x-load-${MACHINE}.bin.ift"
XLOAD_USB_IMAGE ?= "x-load-usb-${MACHINE}-${PV}-${PR}.bin"
XLOAD_USB_SYMLINK ?= "x-load-usb-${MACHINE}.bin"
MLO_IMAGE ?= "MLO-${MACHINE}-${PV}-${PR}"
MLO_SYMLINK ?= "MLO-${MACHINE}"
MLO_SYMLINK_NOMACHINE ?= "MLO"
XLOAD_LOAD_ADDRESS ?= 0x40200800

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake distclean
	oe_runmake ${XLOAD_MACHINE}
	oe_runmake
}

do_install () {
	signGP ${S}/x-load.bin ${XLOAD_LOAD_ADDRESS}

	install -d ${D}/boot
	install ${S}/x-load.bin.ift ${D}/boot/${MLO_IMAGE}
	ln -sf ${MLO_IMAGE} ${D}/boot/${MLO_SYMLINK_NOMACHINE} 
}

FILES_${PN} = "/boot"

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/x-load.bin.ift ${DEPLOY_DIR_IMAGE}/${XLOAD_IMAGE}
	install ${S}/x-load.bin ${DEPLOY_DIR_IMAGE}/${XLOAD_USB_IMAGE}	
	install ${S}/x-load.bin.ift ${DEPLOY_DIR_IMAGE}/${MLO_IMAGE}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${XLOAD_IMAGE}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${XLOAD_USB_IMAGE}	
	package_stagefile_shell	${DEPLOY_DIR_IMAGE}/${MLO_IMAGE}

	cd ${DEPLOY_DIR_IMAGE}
	rm -f ${XLOAD_SYMLINK}
	ln -sf ${XLOAD_IMAGE} ${XLOAD_SYMLINK}
	rm -f ${XLOAD_USB_SYMLINK}
	ln -sf ${XLOAD_USB_IMAGE} ${XLOAD_USB_SYMLINK}	
	rm -f ${MLO_SYMLINK}
	ln -sf ${MLO_IMAGE} ${MLO_SYMLINK}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${XLOAD_SYMLINK}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${XLOAD_USB_SYMLINK}
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${MLO_SYMLINK}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_install
