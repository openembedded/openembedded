DESCRIPTION = "Bluetooh Download Data from remote phones"
HOMEPAGE = "http://www.saftware.de"
SECTION = "apps"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "bluez-libs"

SRC_URI = "http://www.saftware.de/bluetooth/btxml.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CPPFLAGS} -c -o btxml.o btxml.c
    ${CC} -o btxml -lbluetooth -L${STAGING_LIBDIR} btxml.o
}

do_install() {
    install -d ${D}${bindir}/
    install -m 0775 btxml ${D}${bindir}/
}
