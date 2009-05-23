DESCRIPTION = "SHR splash screen"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "1.2-gitr${SRCPV}"
PR = "r2"
RDEPENDS += "virtual/shr-splash-theme"

inherit update-rc.d

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"

S = "${WORKDIR}/git/${PN}"

FILES_${PN} = "${datadir}/shr-splash \
	       ${sysconfdir}/init.d/shr-splash.sh \
"

do_install() {
    install -d ${D}${datadir}/shr-splash
    install -d ${D}${datadir}/shr-splash/themes
    install -d ${D}${sysconfdir}/init.d

    install -m 0755 ${S}/shr-splash.sh        ${D}${sysconfdir}/init.d/shr-splash.sh

}

INITSCRIPT_NAME = "shr-splash.sh"
INITSCRIPT_PARAMS = "start 01 S . stop 20 0 1 6 ."
