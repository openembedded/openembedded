DESCRIPTION = "ACX (iPAQ HX4700/HTC Universal) wireless firmware."
SECTION = "base"
LICENSE = "Unknown"
PR = "r2"
RRECOMMENDS = "kernel-module-firmware-class"

SRC_URI = "http://sdgsystems.com/pub/ipaq/hx4700/src/RADIO0d.BIN \
           http://sdgsystems.com/pub/ipaq/hx4700/src/RADIO11.BIN \
           http://sdgsystems.com/pub/ipaq/hx4700/src/WLANGEN.BIN "

S = "${WORKDIR}"
FILES_${PN} = "/lib"

do_install() {
	install -d ${D}/lib/firmware/
	install -m 0644 RADIO0d.BIN RADIO11.BIN WLANGEN.BIN ${D}/lib/firmware/
}

PACKAGE_ARCH = "all"

