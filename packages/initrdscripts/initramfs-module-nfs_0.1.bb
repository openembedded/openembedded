SRC_URI = "file://nfsboot.sh"
PR = "r1"

do_install() {
        install -m 0755 ${WORKDIR}/nfsboot.sh ${D}/initrd.d/nfs
}

FILES_${PN} += " /initrd.d/nfs "
