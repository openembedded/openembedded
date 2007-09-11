SRC_URI = "file://jffs2boot.sh"
PR = "r1"

do_install() {
        install -m 0755 ${WORKDIR}/jffs2boot.sh ${D}/init
}

FILES_${PN} += " /init "
