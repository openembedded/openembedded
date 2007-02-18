DESCRIPTION = "GSM/GPRS mux tools"
LICENSE  = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
DEPENDS  = "glibc"
PR = "r0"

inherit gpephone

SRC_URI = "${GPEPHONE_MIRROR}/GPRS/GPRS-${PV}.tar.bz2"

S  = ${WORKDIR}/GPRS/connect

do_compile() {
        oe_runmake PREFIX=${prefix}
}

do_install() {
	install -d  ${D}/${prefix}/bin
        install -m755 connect ${D}/${prefix}/bin
        install -m755 disconnect ${D}/${prefix}/bin
}
