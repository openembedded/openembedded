QTVERSION="4.4.3"
FILESDIR += "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qmake2"

BBCLASSEXTEND = "native sdk"

require ${PN}.inc

SRC_URI += "file://qmake-hack.diff;patch=1"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 bin/qmake ${D}/${bindir}/qmake2
    install -m 0755 bin/qmake ${D}/${bindir}/qmake-qt4
    install -d ${D}/${datadir}/qt4
    cp -PfR mkspecs ${D}/${datadir}/qt4/
}


