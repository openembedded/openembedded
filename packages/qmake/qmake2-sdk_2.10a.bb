QTVERSION="4.3.3"
require qmake2-native.inc

inherit sdk

do_install () {
	install -d ${D}/${bindir}
    install -m 0755 bin/qmake ${D}/${bindir}/qmake2
    install -m 0755 bin/qmake ${D}/${bindir}/qmake-qt4
    install -d ${D}/${datadir}/qt4
    cp -PfR mkspecs ${D}/${datadir}/qt4/
}





