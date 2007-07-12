SRC_URI = "file://devimage.sh file://passwd file://dropbear_rsa_host_key"
PR = "r0.7"

do_install() {
        install -m 0755 ${WORKDIR}/devimage.sh ${D}/init
	install -d ${D}/etc/dropbear
        install -m 0600 ${WORKDIR}/dropbear_rsa_host_key ${D}/etc/dropbear/
        install -m 0644 ${WORKDIR}/passwd ${D}/etc/
}

FILES_${PN} += " /init /etc/*"
