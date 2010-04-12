DESCRIPTION = "ACX (iPAQ HX4700/HTC Universal) wireless firmware."
SECTION = "base"
LICENSE = "Unknown"
PR = "r2"
RRECOMMENDS = "kernel-module-firmware-class"

SRC_URI = "http://sdgsystems.com/pub/ipaq/hx4700/src/RADIO0d.BIN;name=radio0d \
           http://sdgsystems.com/pub/ipaq/hx4700/src/RADIO11.BIN;name=radio11 \
           http://sdgsystems.com/pub/ipaq/hx4700/src/WLANGEN.BIN;name=wlangen "

S = "${WORKDIR}"
FILES_${PN} = "/lib"

do_install() {
	install -d ${D}/lib/firmware/
	install -m 0644 RADIO0d.BIN RADIO11.BIN WLANGEN.BIN ${D}/lib/firmware/
}

PACKAGE_ARCH = "all"


SRC_URI[radio0d.md5sum] = "bbd9673a8de1f15c660b80931ce91b25"
SRC_URI[radio0d.sha256sum] = "ee75c05bb8a17a7978abbbc0f38fb79b1915c1e2357889e65657a39024d5b3a3"
SRC_URI[radio11.md5sum] = "a150750ad33c512edc4afee5270b37cb"
SRC_URI[radio11.sha256sum] = "e005a93a0b463e01edba2b79038b54c29a7932efee61c851a2ac644b8a4e5dd4"
SRC_URI[wlangen.md5sum] = "9716488c2d1cf2e5f97b165be4de18db"
SRC_URI[wlangen.sha256sum] = "3d92318dadef22b1d1b062925ef66bac2ad48a0fd4fc83b88dcabba38c182b7b"
