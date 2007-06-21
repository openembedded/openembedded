require openocd_${PV}.bb

inherit native

DEPENDS = "libftdi-native"
EXTRA_OECONF = "--enable-ft2232_libftdi --enable-parport-ppdev"

do_stage() {
    install -m 0755 src/openocd ${STAGING_BINDIR_NATIVE}
}

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0755 src/openocd ${DEPLOY_DIR_IMAGE}/openocd
}

addtask deploy before do_package after do_install
