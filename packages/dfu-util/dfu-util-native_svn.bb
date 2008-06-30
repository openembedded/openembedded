require dfu-util_${PV}.bb

inherit native

DEPENDS = "libusb-native usbpath-native"

do_stage() {
	install -d ${STAGING_BINDIR_NATIVE}
	install -m 0755 src/dfu-util ${STAGING_BINDIR_NATIVE}/dfu-util-${PV}
}

do_deploy() {
	install -d ${DEPLOY_DIR_TOOLS}
	install -m 0755 src/dfu-util_static ${DEPLOY_DIR_TOOLS}/dfu-util-${PV}
}

addtask deploy before do_package after do_install
