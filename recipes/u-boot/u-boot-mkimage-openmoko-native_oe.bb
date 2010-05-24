require u-boot-openmoko_git.bb

inherit native

PV = "1.2.0+git9912121f7ed804ea58fd62f3f230b5dcfc357d88svn2238"
PR = "r1"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;tag=9912121f7ed804ea58fd62f3f230b5dcfc357d88 \
file://uboot-machtypes.patch \
file://ext2load_hex.patch \
file://uboot-s3c2410-warnings-fix.patch \
file://uboot-strtoul.patch \
file://uboot-cramfs_but_no_jffs2.patch \
file://nand-read_write_oob.patch \
file://uboot-arm920t-gd_in_irq.patch \
file://uboot-arm920_s3c2410_irq_demux.patch \
file://uboot-s3c2410-nand.patch \
file://uboot-cmd_s3c2410.patch \
file://uboot-s3c2410-mmc.patch \
file://env_nand_oob.patch \
file://dynenv-harden.patch \
file://uboot-s3c2410_fb.patch \
file://uboot-20061030-qt2410.patch \
file://uboot-20061030-neo1973.patch \
file://uboot-s3c2410-misccr-definitions.patch \
file://boot-from-ram-reloc.patch \
file://boot-from-ram-and-nand.patch \
file://wakeup-reason-nand-only.patch \
file://uboot-neo1973-resume.patch \
file://nand-dynamic_partitions.patch \
file://uboot-s3c2410-norelocate_irqvec_cpy.patch \
file://uboot-usbtty-acm.patch \
file://uboot-s3c2410_udc.patch \
file://bbt-create-optional.patch \
file://nand-createbbt.patch \
file://dontask.patch \
file://nand-badisbad.patch \
file://uboot-bbt-quiet.patch \
file://raise-limits.patch \
file://splashimage-command.patch \
file://cmd-unzip.patch \
file://enable-splash-bmp.patch \
file://preboot-override.patch \
file://lowlevel_foo.patch \
file://default-env.patch \
file://console-ansi.patch \
file://boot-menu.patch \
file://uboot-dfu.patch \
file://uboot-neo1973-defaultenv.patch \
file://uboot-nand-markbad-reallybad.patch \
file://usbdcore-multiple_configs.patch \
file://neo1973-chargefast.patch \
file://uboot-s3c2440.patch \
file://uboot-smdk2440.patch \
file://uboot-hxd8.patch \
file://uboot-license.patch \
file://uboot-gta02.patch \
file://uboot-s3c2443.patch \
file://uboot-smdk2443.patch \
file://unbusy-i2c.patch \
file://makefile-no-dirafter.patch \
"

PROVIDES = ""
TARGET_LDFLAGS = ""

do_quilt() {
:
}

do_compile () {
        chmod +x board/neo1973/gta01/split_by_variant.sh
        oe_runmake gta01bv3_config
        oe_runmake clean
        oe_runmake tools
}

do_stage () {
        install -m 0755 tools/mkimage ${STAGING_BINDIR}/uboot-mkimage
        ln -sf ${STAGING_BINDIR}/uboot-mkimage ${STAGING_BINDIR}/mkimage
}

do_deploy () {
:
}

