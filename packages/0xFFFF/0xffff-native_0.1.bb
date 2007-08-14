require 0xffff.inc

DEPENDS = "libusb-native"

inherit native

do_stage() {
        install -d ${STAGING_BINDIR_NATIVE}
	install -m 755 0xFFFF ${STAGING_BINDIR_NATIVE}
}

do_deploy[dirs] = "${S}"

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 755 0xFFFF ${DEPLOY_DIR_IMAGE}
}

addtask deploy before do_package after do_install


