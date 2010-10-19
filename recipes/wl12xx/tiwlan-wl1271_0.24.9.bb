DESCRIPTION = "Driver and loader apps for wl1271 based chipsets"
LICENSE = "GPLv2 TI"

inherit module

SRC_URI = "https://edge.launchpad.net/~tiomap-dev/+archive/release/+files/tiwlan-wl1271_${PV}.orig.tar.gz"
SRC_URI[md5sum] = "12a26535b4f3c30b24c6a1ae00d84ea0"
SRC_URI[sha256sum] = "60a64c8c3daee9dc897a8918e2f082bcfcb4a3dbd66c013978e331e1c8e6127b"

MACHINE_KERNEL_PR_append = "a"

PARALLEL_MAKE = ""

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS
	oe_runmake ${MODULE_MAKE_FLAGS} AR=ar KERNEL_DIR=${STAGING_KERNEL_DIR} -C wlan/platforms/os/linux HOST_PLATFORM=sdc4430 BUILD_SUPPL=n CU_DK
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	cd wlan
	oe_runmake ${MODULE_MAKE_FLAGS} AR=ar KERNEL_DIR=${STAGING_KERNEL_DIR} -C platforms/os/linux HOST_PLATFORM=sdc4430 BUILD_SUPPL=n ../../../platforms/os/linux/tiwlan_drv.ko sdio
}


do_install() {
	install -d ${D}${bindir}
	install -m 755 "wlan/CUDK/output/tiwlan_loader" "${D}${bindir}/tiwlan_loader_wl1271"
	install -m 755 "wlan/CUDK/output/wlan_cu" "${D}${bindir}/wlan_cu_wl1271"

	install -d ${D}/lib/firmware/tiwlan-wl1271
	install -m 644 "wlan/platforms/os/linux/tiwlan.ini" ${D}/lib/firmware/tiwlan-wl1271
	install -m 644 "wlan/platforms/os/linux/tiwlan_dual.ini" ${D}/lib/firmware/tiwlan-wl1271

    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/sdio
	cp wlan/platforms/os/linux/tiwlan_drv.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/sdio
	cp wlan/external_drivers/sdc4430/Linux/sdio/sdio.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/sdio
}

PACKAGES =+ "tiwlan-wl1271-apps"

FILES_${PN} += "${base_libdir}/firmware"
FILES_tiwlan-wl1271-apps = "${bindir}"

