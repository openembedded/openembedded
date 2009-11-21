DESCRIPTION = "illume SHR sysactions config"
SECTION = "e/utils"
LICENSE = "MIT BSD"
PV = "1.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r4"

RPROVIDES_${PN} = "e-wm-sysactions"
RCONFLICTS_${PN} = "e-wm-sysactions"
#RREPLACES_${PN} = "e-wm-sysactions"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

FILES_${PN} = "${sysconfdir}/enlightenment"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment/
    install -m 0755 ${S}/sysactions.conf ${D}${sysconfdir}/enlightenment/sysactions.conf
    install -m 0755 ${S}/suspend.sh ${D}${sysconfdir}/enlightenment/suspend.sh
    install -m 0755 ${S}/lock.sh ${D}${sysconfdir}/enlightenment/lock.sh
}
