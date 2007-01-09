LICENSE = "MIT"
PR = "r2"

COMPATIBLE_MACHINE = "(h3600|h3800|h3900|h5000|simpad)"

SRC_URI = "file://params"

do_install() {
        install -d ${D}/boot
        install -m 0644 ${WORKDIR}/params ${D}/boot/
}

FILES_${PN} = "/boot/params"
PACKAGE_ARCH = "${MACHINE_ARCH}"

