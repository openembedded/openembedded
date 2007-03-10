require ftdi-eeprom_${PV}.bb

DEPENDS = "libftdi-native confuse-native"

do_stage() {
    install -m 0755 ftdi_eeprom/ftdi_eeprom ${STAGING_BINDIR_NATIVE}
}

