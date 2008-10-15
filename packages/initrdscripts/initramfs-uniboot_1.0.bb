SRC_URI = "file://init.sh"
FILE_PR = "r9"
DESCRIPTON = "A modular initramfs init script system."
RRECOMMENDS = "kernel-module-mtdblock"

do_install() {
        install -m 0755 ${WORKDIR}/init.sh ${D}/init
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /init "
