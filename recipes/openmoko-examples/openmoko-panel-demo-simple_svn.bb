DESCRIPTION = "A simple example panel plugin for Openmoko"
SECTION = "openmoko/examples"
DEPENDS += "libmatchbox"
PV = "0.0.1+svnr${SRCPV}"

PR = "r1"

inherit openmoko

do_configure_prepend() {
	sed -i -e s:-Werror::g src/Makefile.am
}	


FILES_${PN} += "${libdir}/matchbox-panel/*.so.*"
FILES_${PN}-dev += "${libdir}/matchbox-panel/*.so \
                    ${libdir}/matchbox-panel/*.la"
FILES_${PN}-dbg += "${libdir}/matchbox-panel/.debug"

