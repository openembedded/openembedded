QTVERSION="4.4.3"
FILESDIR += "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/qmake2-native"

inherit native

require ${PN}.inc

do_install() {
    :
}


