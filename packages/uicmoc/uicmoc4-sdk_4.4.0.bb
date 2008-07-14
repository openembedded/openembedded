require uicmoc4-native.inc

inherit sdk 

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://configure-fix.patch;patch=1 \
           file://qapplication.diff;patch=1 "

S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

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


