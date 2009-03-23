DESCRIPTION = "Set of files to initialize bare system suitable for kernel, etc. testing."
SRC_URI = "file://devimage.sh file://passwd file://dropbear_rsa_host_key"
PR = "r4"

do_install() {
	install -d ${D}/etc/dropbear
	install -d ${D}/sbin
	install -m 0755 ${WORKDIR}/devimage.sh ${D}/init
        install -m 0600 ${WORKDIR}/dropbear_rsa_host_key ${D}/etc/dropbear/
        install -m 0644 ${WORKDIR}/passwd ${D}/etc/
	ln -s /init ${D}/sbin/init
}

FILES_${PN} += " /init /etc/* /sbin/*"
