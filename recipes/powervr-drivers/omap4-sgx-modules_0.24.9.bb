DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap4 SoCs"
LICENSE = "GPLv2"

SRC_URI = "http://launchpadlibrarian.net/57660939/pvr-omap4-kernel_${PV}.orig.tar.gz \
           file://0001-hack-add-omapfb-h.patch;striplevel=2 \
          "

SRC_URI[md5sum] = "14e6c4b3ecf34f7f07c97ca2f6924f77"
SRC_URI[sha256sum] = "0b404586a23eaebaa586ec18fd1da8cb3eed7682b1887823527ac62195e104bb"

S = "${WORKDIR}/pvr-omap4-kernel-${PV}/sgx"

inherit module

MACHINE_KERNEL_PR_append = "a"

MAKE_TARGETS = "-C eurasiacon/build/linux/omap4430_linux/kbuild BUILD=release"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp eurasiacon/binary_omap4430_linux_release/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}

PACKAGE_STRIP = "no"


