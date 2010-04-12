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



SRC_URI[md5sum] = "31cd82986ccfabdf01a6a99aa00f975b"
SRC_URI[sha256sum] = "6d061f8431b76ba1dd09401880c7029e490be8c04cac14ba89db7ea7d0ab77bf"
