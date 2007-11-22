SRC_URI = "file://init.sh"
PR = "r0"
DESCRIPTON = "A modular initramfs init script system."
RDEPENDS = "busybox-static"
RRECOMMENDS = "kernel-module-uinput"

do_install() {
        install -m 0755 ${WORKDIR}/init.sh ${D}/init
}

FILES_${PN} += " /init "
