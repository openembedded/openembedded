DESCRIPTION = "Barebox - a bootloader that inherits the best of U-Boot and the Linux kernel"
HOMEPAGE = "http://www.barebox.org/"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "virtual/bootloader"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit kernel-arch

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

BAREBOX_MACHINE ?= "${MACHINE}_defconfig"
BAREBOX_BINARY ?= "barebox.bin"
BAREBOX_IMAGE ?= "barebox-${MACHINE}-${PV}-${PR}.bin"
BAREBOX_SYMLINK ?= "barebox-${MACHINE}.bin"

INSANE_SKIP_${PN} = True

do_configure_prepend() {
	   cp ${WORKDIR}/defconfig ${S}/.config
	   oe_runmake oldconfig
}

do_compile () {
	   unset LDFLAGS
	   unset CFLAGS
	   unset CPPFLAGS
	   oe_runmake all
}

do_deploy () {
	  install -d ${DEPLOY_DIR_IMAGE}
	  install ${S}/${BAREBOX_BINARY} ${DEPLOY_DIR_IMAGE}/${BAREBOX_IMAGE}
	  package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${BAREBOX_IMAGE}

	  cd ${DEPLOY_DIR_IMAGE}
	  rm -f ${BAREBOX_SYMLINK}
	  ln -sf ${BAREBOX_IMAGE} ${BAREBOX_SYMLINK}
	  package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${BAREBOX_SYMLINK}
}
do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile

do_stage() {
	   install -d ${STAGING_BINDIR_NATIVE}
	   install -m 755 scripts/mkimage ${STAGING_BINDIR_NATIVE}/
}
