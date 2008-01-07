DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+"
RRECOMMENDS = "gpsd speechd flite"

inherit autotools

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"
FILES_${PN}-dev += "${libdir}/${PN}/*/*.so"

SRC_URI_append = " \
	    	  file://navit.launcher \
	  	 "

do_install_append() {
	install -d ${D}/usr/share/applications/
	
	install -m 0644 ${WORKDIR}/navit.desktop ${D}/usr/share/applications/
	
	mv ${D}/usr/bin/navit ${D}/usr/bin/navit.real
	
	install -m 0755 ${WORKDIR}/navit.launcher ${D}/usr/bin/navit
}
