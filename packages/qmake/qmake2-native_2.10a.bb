QTVERSION="4.3.3"
FILESDIR += "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qmake2-native"
require ${PN}.inc

inherit cross

do_install() {
    :
}


