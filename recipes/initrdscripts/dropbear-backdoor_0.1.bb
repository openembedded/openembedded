DESCRIPTION = "Set of files to open up unlimited access to dropbear daemon - DEBUG ONLY!"
SRC_URI = "file://passwd file://dropbear_rsa_host_key"
PR = "r0"

do_install() {
	install -d ${D}/etc/dropbear
        install -m 0600 ${WORKDIR}/dropbear_rsa_host_key ${D}/etc/dropbear/
        install -m 0644 ${WORKDIR}/passwd ${D}/etc/
}

FILES_${PN} += " /etc/* "
