DESCRIPTION = "GSM/GPRS mux initializer"
LICENSE  = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
DEPENDS  = "glibc"
PR = "r0"

inherit gpephone

SRC_URI = "${GPEPHONE_MIRROR}/GPRS/GPRS-${PV}.tar.bz2 \
           file://oe-install.patch;patch=1"


S  = ${WORKDIR}/GPRS/cms92init-simple

do_compile() {
        oe_runmake PREFIX=${prefix}
}

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install
}
