FILES_${PN} = "/boot/params"

LICENSE = "MIT"
SRC_URI = "file://params"

do_install() {
	install -d ${D}/boot
	install -m 0644 ${WORKDIR}/params ${D}/boot/
}

