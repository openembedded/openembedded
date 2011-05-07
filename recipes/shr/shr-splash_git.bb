DESCRIPTION = "SHR splash screen"
SECTION = "x11/data"
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f523ab5986cc79b52a90d2ac3d5454a2"
SRCREV = "290dbca51030ff585bb1631be11799e88944e7f9"
PV = "1.2+gitr${SRCPV}"
PR = "r7"
SHR_SPLASH_THEME ?= "shr-splash-theme-logo"
DEPENDS = "${SHR_SPLASH_THEME}"
RRECOMMENDS_${PN} = "${SHR_SPLASH_THEME}"

inherit update-rc.d gettext

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master \
"
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

pkg_postinst() {
    [ -e ${datadir}/pixmaps/xsplash-vga.ppm ] || ln -s ${datadir}/shr-splash/theme/xsplash-vga.ppm ${datadir}/pixmaps/xsplash-vga.ppm
}


INITSCRIPT_NAME = "shr-splash.sh"
INITSCRIPT_PARAMS = "start 01 S . stop 21 0 1 6 ."
