DESCRIPTION = "Polish dictionary for Illume keyboard"
SECTION = "x11/data"
PV = "1.0-gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

FILES_${PN} = "${libdir}/enlightenment/modules/illume/dicts/Polish.dic"

do_install() {
    install -d ${D}${libdir}/enlightenment/modules/illume/dicts
    install -m 0644 ${S}/Polish.dic        ${D}${libdir}/enlightenment/modules/illume/dicts/Polish.dic
}
