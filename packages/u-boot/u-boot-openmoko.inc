DESCRIPTION = "U-boot bootloader w/ Neo1973 (GTA01) and Neo FreeRunner (GTA02) support"
AUTHOR = "Harald Welte <laforge@openmoko.org> et. al."
LICENSE = "GPL"
SECTION = "bootloader"
PRIORITY = "optional"
PROVIDES = "virtual/bootloader"
LOCALVERSION = "+gitr${SRCREV}"
PV = "1.3.1${LOCALVERSION}"
PR = "r0"

UBOOT_MACHINES = "gta01bv2 gta01bv3 gta01bv4 gta02v2 gta02v4 gta02v5"

DEFAULT_PREFERENCE = "-1"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""

do_svnrev() {
	mv -f tools/setlocalversion tools/setlocalversion.old
	echo "echo ${LOCALVERSION}" >>tools/setlocalversion
}

do_compile () {
	chmod +x board/neo1973/gta*/split_by_variant.sh
	for mach in ${UBOOT_MACHINES}
	do
		oe_runmake ${mach}_config
		oe_runmake clean
		find board -name lowlevel_foo.bin -exec rm '{}' \;
		oe_runmake all
		oe_runmake u-boot.udfu
		if [ -f u-boot.udfu ]; then
			mv u-boot.udfu u-boot_${mach}.bin
		else
			mv u-boot.bin u-boot_${mach}.bin
		fi
		if [ -f board/${mach}/lowlevel_foo.bin ]; then
			mv board/${mach}/lowlevel_foo.bin lowlevel_foo_${mach}.bin
		else
			find board -name lowlevel_foo.bin -exec mv '{}' lowlevel_foo_${mach}.bin \;
		fi
	done
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	for mach in ${UBOOT_MACHINES}
	do
		install -m 0644 ${S}/u-boot_${mach}.bin ${DEPLOY_DIR_IMAGE}/u-boot-${mach}-${PV}-${PR}.bin
		ln -sf ${DEPLOY_DIR_IMAGE}/u-boot-${mach}-${PV}-${PR}.bin ${DEPLOY_DIR_IMAGE}/uboot-${mach}-latest.bin
		if [ -f ${S}/lowlevel_foo_${mach}.bin ]; then
			install -m 0644 ${S}/lowlevel_foo_${mach}.bin ${DEPLOY_DIR_IMAGE}/lowlevel_foo-${mach}-${PV}-${PR}.bin
			ln -sf ${DEPLOY_DIR_IMAGE}/lowlevel_foo-${mach}-${PV}-${PR}.bin ${DEPLOY_DIR_IMAGE}/lowlevel-foo-${mach}-latest.bin
		fi
	done
	install -m 0755 tools/mkimage ${STAGING_BINDIR_NATIVE}/uboot-mkimage
}

do_deploy[dirs] = "${S}"
addtask deploy before do_package after do_install
addtask quilt before do_patch after do_unpack
addtask svnrev before do_patch after do_quilt
