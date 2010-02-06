DESCRIPTION = "Ligthweight Qt telephony app"
AUTHOR = "Michal Brzozowski"
HOMEPAGE = "http://www.litephone.org"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL QPL"
RRECOMMENDS = "fsodeviced fsogsmd fsousaged frameworkd"
INC_PR = "r0"

inherit qt4x11

do_configure() {
    ${OE_QMAKE_QMAKE} QMAKE_LRELEASE=lrelease4
}

do_compile() {
    oe_runmake
}
