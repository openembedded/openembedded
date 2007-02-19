require openocd_${PV}.bb

inherit native

DEPENDS = "libftdi-native"
EXTRA_OECONF = "--enable-ft2232_libftdi --enable-parport-ppdev"

do_stage() {
    install -m 0755 src/openocd ${STAGING_BINDIR}
}

