DESCRIPTION = "U-Boot - the Universal Boot Loader"
HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPLv2"
PROVIDES = "virtual/bootloader"

DEPENDS = "mtd-utils"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PARALLEL_MAKE=""

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

UBOOT_MACHINE ?= "${MACHINE}_config"
UBOOT_BINARY ?= "u-boot.bin"
UBOOT_IMAGE ?= "u-boot-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SYMLINK ?= "u-boot-${MACHINE}.bin"

do_configure () {
	oe_runmake ${UBOOT_MACHINE}
}

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake all
	oe_runmake tools env
}

do_install () {
	install -d ${D}/boot
	if ! [ "x${UBOOT_MACHINES}" == "x" ] ; then
		for board in ${UBOOT_MACHINES} ; do
			if ! [ `grep ${board}_config ${S}/Makefile | wc -c` == 0 ] ; then
				install ${S}/binaries/${board}/${UBOOT_BINARY} ${D}/boot/${board}-u-boot-${PV}-${PR}.bin
			fi
			if [ -e ${WORKDIR}/binaries/${board}/fw_env.config ] ; then
				if ! [ -e ${D}${sysconfdir}/fw_env.config ] ; then
					install -d ${D}${base_sbindir}
					install -d ${D}${sysconfdir}
					install -m 644 ${WORKDIR}/binaries/${board}/fw_env.config ${D}${sysconfdir}/fw_env.config
					install -m 755 ${S}/binaries/${board}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
					install -m 755 ${S}/binaries/${board}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
				fi
			fi
		done
	else
		install ${S}/${UBOOT_BINARY} ${D}/boot/${UBOOT_IMAGE}
		ln -sf ${UBOOT_IMAGE} ${D}/boot/${UBOOT_BINARY}

		if [ -e ${WORKDIR}/fw_env.config ] ; then
		    install -d ${D}${base_sbindir}
			install -d ${D}${sysconfdir}
			install -m 644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
			install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_printenv
			install -m 755 ${S}/tools/env/fw_printenv ${D}${base_sbindir}/fw_setenv
		fi
	fi

}

FILES_${PN} = "/boot"
# no gnu_hash in uboot.bin, by design, so skip QA
INSANE_SKIP_${PN} = True

PACKAGES += "${PN}-fw-utils"
FILES_${PN}-fw-utils = "${sysconfdir} ${base_sbindir}"
# u-boot doesn't use LDFLAGS for fw files, needs to get fixed, but until then:
INSANE_SKIP_${PN}-fw-utils = True

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	if ! [ "x${UBOOT_MACHINES}" == "x" ] ; then
		for board in ${UBOOT_MACHINES} ; do
			install ${S}/binaries/${board}/${UBOOT_BINARY}	${DEPLOY_DIR_IMAGE}/${board}-u-boot-${PV}-${PR}.bin
			package_stagefile_shell				${DEPLOY_DIR_IMAGE}/${board}-u-boot-${PV}-${PR}.bin
		done
	else
		install ${S}/${UBOOT_BINARY} ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
		package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${UBOOT_IMAGE}
		cd ${DEPLOY_DIR_IMAGE}
		rm -f ${UBOOT_SYMLINK}
		ln -sf ${UBOOT_IMAGE} ${UBOOT_SYMLINK}
		package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${UBOOT_SYMLINK}
	fi
}
do_deploy[dirs] = "${S}"
addtask deploy before do_package_stage after do_compile
