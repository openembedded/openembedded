SRC_URI = "file://init.sh"
PR = "r0"

do_install() {
        install -m 0755 ${WORKDIR}/init.sh ${D}/init
}

FILES_${PN} += " /init "
