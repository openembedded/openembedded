SECTION = "gpe"
PRIORITY    = "optional"
DESCRIPTION = "Suspend feature for the application launcher menu."
LICENSE     = "GPL"

PR          = "r2"

DISTRO_APM ?= "apm"
RDEPENDS    = "gpe-conf"
RRECOMMENDS = "${DISTRO_APM}"

PACKAGES    = "${PN}"
PACKAGE_ARCH = "all"

SRC_URI = "file://suspend.desktop \
           file://suspend.sh"

FILES_${PN} = "${bindir} ${datadir}"

do_compile() {
}

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/applications
	install -m 644 ${WORKDIR}/suspend.desktop ${D}/${datadir}/applications/suspend.desktop
	install -m 755 ${WORKDIR}/suspend.sh ${D}/${bindir}/suspend.sh
}
