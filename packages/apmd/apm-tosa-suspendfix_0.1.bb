DESCRIPTION = "Workaround for bug 2134 (Tosa Angstrom x11 image suspend/resume failure)"
AUTHOR = "Dmitry Baryshkov"
PR = "r0"

SRC_URI = "file://50-tmio-ohci-unbind"

do_install() {
	install -d ${D}${sysconfdir}/apm/event.d
	install -m 0755 ${WORKDIR}/50-tmio-ohci-unbind ${D}${sysconfdir}/apm/event.d
}
