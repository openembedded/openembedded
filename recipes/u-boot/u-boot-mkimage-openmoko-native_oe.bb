require u-boot-openmoko_git.bb

inherit native

PV = "1.2.0+git9912121f7ed804ea58fd62f3f230b5dcfc357d88svn2238"
PR = "r1"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;tag=9912121f7ed804ea58fd62f3f230b5dcfc357d88 \
file://uboot-machtypes.patch;apply=yes \
file://ext2load_hex.patch;apply=yes \
file://uboot-s3c2410-warnings-fix.patch;apply=yes \
file://uboot-strtoul.patch;apply=yes \
file://uboot-cramfs_but_no_jffs2.patch;apply=yes \
file://nand-read_write_oob.patch;apply=yes \
file://uboot-arm920t-gd_in_irq.patch;apply=yes \
file://uboot-arm920_s3c2410_irq_demux.patch;apply=yes \
file://uboot-s3c2410-nand.patch;apply=yes \
file://uboot-cmd_s3c2410.patch;apply=yes \
file://uboot-s3c2410-mmc.patch;apply=yes \
file://env_nand_oob.patch;apply=yes \
file://dynenv-harden.patch;apply=yes \
file://uboot-s3c2410_fb.patch;apply=yes \
file://uboot-20061030-qt2410.patch;apply=yes \
file://uboot-20061030-neo1973.patch;apply=yes \
file://uboot-s3c2410-misccr-definitions.patch;apply=yes \
file://boot-from-ram-reloc.patch;apply=yes \
file://boot-from-ram-and-nand.patch;apply=yes \
file://wakeup-reason-nand-only.patch;apply=yes \
file://uboot-neo1973-resume.patch;apply=yes \
file://nand-dynamic_partitions.patch;apply=yes \
file://uboot-s3c2410-norelocate_irqvec_cpy.patch;apply=yes \
file://uboot-usbtty-acm.patch;apply=yes \
file://uboot-s3c2410_udc.patch;apply=yes \
file://bbt-create-optional.patch;apply=yes \
file://nand-createbbt.patch;apply=yes \
file://dontask.patch;apply=yes \
file://nand-badisbad.patch;apply=yes \
file://uboot-bbt-quiet.patch;apply=yes \
file://raise-limits.patch;apply=yes \
file://splashimage-command.patch;apply=yes \
file://cmd-unzip.patch;apply=yes \
file://enable-splash-bmp.patch;apply=yes \
file://preboot-override.patch;apply=yes \
file://lowlevel_foo.patch;apply=yes \
file://default-env.patch;apply=yes \
file://console-ansi.patch;apply=yes \
file://boot-menu.patch;apply=yes \
file://uboot-dfu.patch;apply=yes \
file://uboot-neo1973-defaultenv.patch;apply=yes \
file://uboot-nand-markbad-reallybad.patch;apply=yes \
file://usbdcore-multiple_configs.patch;apply=yes \
file://neo1973-chargefast.patch;apply=yes \
file://uboot-s3c2440.patch;apply=yes \
file://uboot-smdk2440.patch;apply=yes \
file://uboot-hxd8.patch;apply=yes \
file://uboot-license.patch;apply=yes \
file://uboot-gta02.patch;apply=yes \
file://uboot-s3c2443.patch;apply=yes \
file://uboot-smdk2443.patch;apply=yes \
file://unbusy-i2c.patch;apply=yes \
file://makefile-no-dirafter.patch;apply=yes \
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

