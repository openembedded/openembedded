SRC_URI = "file://init.sh"
PR = "r2"
DESCRIPTON = "A modular initramfs init script system."

do_install() {
        install -m 0755 ${WORKDIR}/init.sh ${D}/init
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /init "
