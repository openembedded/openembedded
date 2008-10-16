require uicmoc4-native.inc

inherit native

do_stage() {
    install -d ${STAGING_BINDIR}/
    install -m 0755 bin/moc ${STAGING_BINDIR}/moc4
    install -m 0755 bin/uic ${STAGING_BINDIR}/uic4
    install -m 0755 bin/uic3 ${STAGING_BINDIR}/uic34
    install -m 0755 bin/rcc ${STAGING_BINDIR}/rcc4
    install -m 0755 bin/lrelease ${STAGING_BINDIR}/lrelease4
    install -m 0755 bin/lupdate ${STAGING_BINDIR}/lupdate4
    install -d ${STAGING_DIR_NATIVE}/qt4/
    install -m 0644 tools/porting/src/q3porting.xml ${STAGING_DIR_NATIVE}/qt4/
}

