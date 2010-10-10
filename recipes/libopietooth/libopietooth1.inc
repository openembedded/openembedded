DESCRIPTION = "Opie Bluetooth library"
SECTION = "opie/libs"
PRIORITY = "optional"
DEPENDS = "libopie2"
LICENSE = "LGPL"

S = "${WORKDIR}/lib"

inherit opie

do_install() {
    oe_libinstall -so libopietooth1 ${D}${libdir}
    install -d ${D}${includedir}/opietooth/
    install -m 0644 *.h ${D}${includedir}/opietooth/
}
