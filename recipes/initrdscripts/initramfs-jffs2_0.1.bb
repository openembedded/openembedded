SRC_URI = "file://jffs2boot.sh"
PR = "r4"
RRECOMMENDS_${PN} = "kernel-module-mtdblock kernel-module-mtdram"

do_install() {
        install -m 0755 ${WORKDIR}/jffs2boot.sh ${D}/init
}

PACKAGE_ARCH = "all"
FILES_${PN} += " /init "
