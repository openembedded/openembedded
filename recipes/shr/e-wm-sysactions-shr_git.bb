DESCRIPTION = "illume SHR sysactions config"
SECTION = "e/utils"
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f523ab5986cc79b52a90d2ac3d5454a2"
SRCREV = "e1dc24ceb49e09f051a5d12b839572fb33de8b48"
PV = "1.2+gitr${SRCPV}"
PR = "r6"
PACKAGE_ARCH = "all"

RCONFLICTS_${PN} = "e-wm-sysactions"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http \
"
S = "${WORKDIR}/git/e-wm/${PN}"

FILES_${PN} = "${sysconfdir}/enlightenment"

do_install() {
    install -d ${D}${sysconfdir}/enlightenment/
    install -m 0755 ${S}/sysactions.conf ${D}${sysconfdir}/enlightenment/sysactions.conf
    install -m 0755 ${S}/suspend.sh ${D}${sysconfdir}/enlightenment/suspend.sh
    install -m 0755 ${S}/lock.sh ${D}${sysconfdir}/enlightenment/lock.sh
}
