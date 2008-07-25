require lcdproc5.inc

DEPENDS += "libg15 g15daemon libg15render"
DEPENDS_lcdd-driver-all += "lcdd-driver-g15"

PR = "r3"

do_install_append () {
	# binaries
	install -D -m 0755 clients/lcdvc/lcdvc ${D}${sbindir}/lcdvc

	# configuration files
	install -D -m 0644 clients/lcdvc/lcdvc.conf ${D}${sysconfdir}/lcdvc.conf
}

PACKAGES =+ "lcdvc lcdd-driver-g15"
CONFFILES_lcdvc = "${sysconfdir}/lcdvc.conf"
FILES_lcdvc = "${CONFFILES_lcdvc} ${sbindir}/lcdvc"
FILES_lcdd-driver-g15 = "${libdir}/lcdproc/g15.so"
