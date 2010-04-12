require multi-kernel.inc

FILESPATHPKG_prepend = "linux-omap-psp-2.6.32:"

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beagleboard|omap3evm|am3517-evm|omap3-touchbook"

SRCREV = "06733a907b777f7dca21b2d44e36b6c4afbe01fe"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "+gitr${SRCREV}"

SRC_URI += "git://arago-project.org/git/people/sriram/ti-psp-omap.git;protocol=git;branch=master \
           file://0005-ARM-OMAP-add-support-for-TCT-Zippy-to-Beagle-board.patch;patch=1 \
           file://0006-ARM-OMAP-Make-beagle-u-boot-partition-writable.patch;patch=1 \
           file://0007-ASoC-enable-audio-capture-by-default-for-twl4030.patch;patch=1 \
           file://0009-MTD-NAND-omap2-proper-fix-for-subpage-read-ECC-error.patch;patch=1 \
           file://dss2/0015-OMAP-DSS-Add-DSS2-support-for-Beagle.patch;patch=1 \
           file://dss2/0016-video-add-timings-for-hd720.patch;patch=1 \
           file://holes.patch;patch=1 \
           file://no-mmc-spew.patch;patch=1 \
           file://beagleboard/0001-beagleboard-omap3_-foo-_rate_table-omap35x_-foo.patch;patch=1 \
           file://beagleboard/0001-board-omap3beagle-prepare-for-DM3730-based-Beaglebo.patch;patch=1 \
           file://0001-board-omap3touchbook-make-it-build-against-TI-linux.patch;patch=1 \
           file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

addtask quiltfixup before do_patch after do_unpack
do_quiltfixup() {
	rm ${S}/.pc -rf
}

S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}/boot
	install -m 0644 Documentation/arm/OMAP/DSS ${D}/boot/
}

PACKAGES =+ "omap-dss-doc"
FILES_omap-dss-doc = "/boot/DSS"

