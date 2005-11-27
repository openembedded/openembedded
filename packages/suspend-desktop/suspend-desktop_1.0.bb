PR          = "r0"
SECTION     = "gpe"
PRIORITY    = "optional"
DESCRIPTION = "Suspend feature for the application launcher menu."
MAINTAINER  = "Florian Boor <florian@kernelconcepts.de>"
LICENSE     = "GPL"
DEPENDS     = "gpe-conf"
RDEPENDS    = "gpe-conf"
RRECOMMENDS = "apm"
PACKAGES    = ${PN}


SRC_URI = "file://suspend.desktop \
           file://suspend.sh"

FILES_${PN} = "${bindir} ${datadir}"

do_compile() {
}

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/applications
	install -m644 ${WORKDIR}/suspend.desktop ${D}/${datadir}/applications/suspend.desktop
	install -m755 ${WORKDIR}/suspend.sh ${D}/${bindir}/suspend.sh
}
