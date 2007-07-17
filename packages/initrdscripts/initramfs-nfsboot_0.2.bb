SRC_URI = "file://nfsboot.sh"
PR = "r0"

do_install() {
        install -m 0755 ${WORKDIR}/nfsboot.sh ${D}/init
}

FILES_${PN} += " /init "
