DESCRIPTION = "Hacky workaround for bug 3664 (some wifi cards don't recover from suspend) until a real fix is found"
AUTHOR = "Rolf Leggewie"
PR = "r0"

SRC_URI = "file://90-wifi-off"

do_install() {
	install -d ${D}${sysconfdir}/apm/suspend.d
	install -m 0755 ${WORKDIR}/90-wifi-off ${D}${sysconfdir}/apm/suspend.d
}
