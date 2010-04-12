require 0xffff.inc

DEPENDS = "virtual/libusb0-native"

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



SRC_URI[md5sum] = "666fce75c418d7b72e2c9dc225fce3be"
SRC_URI[sha256sum] = "2419708f8e0d7cd6875f4555da9c8a2bf9503374eb7c0bea08fed0841baa4655"
