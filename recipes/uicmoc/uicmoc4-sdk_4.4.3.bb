require uicmoc4-native.inc

inherit sdk 

do_install_append() {
    install -d ${D}/${bindir}
    install -m 0755 bin/moc ${D}/${bindir}/moc4
    install -m 0755 bin/uic ${D}/${bindir}/uic4
    install -m 0755 bin/uic3 ${D}/${bindir}/uic34
    install -m 0755 bin/rcc ${D}/${bindir}/rcc4
    install -m 0755 bin/lrelease ${D}/${bindir}/lrelease4
    install -m 0755 bin/lupdate ${D}/${bindir}/lupdate4
    install -d ${D}/${datadir}/qt4/
    install -m 0644 tools/porting/src/q3porting.xml ${D}/${datadir}/qt4/
}


SRC_URI[md5sum] = "9a639aec44a1e4c70040117183d247a3"
SRC_URI[sha256sum] = "05d06b93f95092f1318634fca24f0c2d0a1252c9f1dc2fbb427b07e8ecbb4f39"
