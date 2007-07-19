SRC_URI = "file://loopboot.sh"
PR = "r0"

do_install() {
        install -m 0755 ${WORKDIR}/loopboot.sh ${D}/initrd.d/loop
}

FILES_${PN} += " /initrd.d/loop "
