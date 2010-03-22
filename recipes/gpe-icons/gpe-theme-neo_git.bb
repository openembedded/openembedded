DESCRIPTION = "nEo GPE theme - a very fast, high contrast GPE theme"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RSUGGESTS = "gpe-filemanager gpe-sketchbook elementary-theme-neo e-wm-theme-illume-neo gtk-theme-neo etk-theme-neo icon-theme-neo"
LICENSE = "unknown"

SRCREV = "1cc80e26a4558dfc2268b349d9a1f468e515bcfb"
PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "${INC_PR}.2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/gpe/theme-neo/pixmaps"

require gpe-icons.inc

ALTERNATIVE_PRIORITY = 10

#installed to /usr/share/gpe/pixmaps.gpe-theme-neo by default as we don't want to overwrite default icons from gpe-icons package
do_install() {
        install -d ${D}${datadir}/gpe/
        install -d ${D}${datadir}/gpe/pixmaps.${PN}/
        cp -r ${S}/* "${D}${datadir}/gpe/pixmaps.${PN}/"
}

FILES_${PN} = "${datadir}/gpe/pixmaps.${PN}/"
