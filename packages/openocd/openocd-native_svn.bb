require openocd_${PV}.bb

inherit native

DEPENDS = "libftdi-native"

do_stage() {
    install -m 0755 src/openocd ${STAGING_BINDIR}
}

