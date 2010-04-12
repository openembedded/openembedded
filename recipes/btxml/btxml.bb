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

SRC_URI[md5sum] = "c17e047d1a6a3f3188de929dc8582e01"
SRC_URI[sha256sum] = "58eb43e7e781a6b61e452fa36fa03198ef44c742da80c8a1b60be073e4ab949b"
