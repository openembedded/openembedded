DESCRIPTION = "Firmware for Spectrum Wireless LAN cards"
DEPENDS += " unzip-native "
LICENSE = "unknown"
PR = "r2"

SRC_URI = "ftp://symstore.longisland.com/Symstore/services_download/wirless_prod/MC&DriverOnlyInstallers.zip;name=zip \
           file://get_symbol_fw \
           file://parse_symbol_fw"
S = "${WORKDIR}"

do_configure() {
	./get_symbol_fw
}

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0755 ${WORKDIR}/symbol_sp24t_prim_fw ${D}${base_libdir}/firmware/symbol_sp24t_prim_fw
	install -m 0755 ${WORKDIR}/symbol_sp24t_sec_fw ${D}${base_libdir}/firmware/symbol_sp24t_sec_fw
}

PACKAGE_ARCH = "all"
FILES_${PN} += "${base_libdir}/firmware/symbol*"

SRC_URI[zip.md5sum] = "48ad5e824af83d4d7a38ef0a3eab0c3b"
SRC_URI[zip.sha256sum] = "c4a960651f91e4485bb74770ab8611fc6b03a677c69d7256422bc56604624982"
