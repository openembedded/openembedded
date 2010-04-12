DESCRIPTION = "FreonDemo: a QT based demo for OMAP L138 EVM board"
HOMEPAGE = "http://sourceforge.net/projects/freondemo"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

inherit qt4e update-rc.d

DEPENDS += "dbus gstd"
RDEPENDS_${PN} = "gstd alsa-utils-amixer gst-ipcsink dbus"
RRECOMMENDS_${PN} = "qt4-embedded-plugin-mousedriver-tslib gstreamer-ti freondemo-media-files"

SRCREV = "e652aa92a99b2aa7c9919299761499b413a348d5"

PV = "1.0"
PR = "r18"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://freondemo.git.sourceforge.net/gitroot/freondemo/freondemo;protocol=git \
           file://freondemo \
           file://freondemo.init \
           "
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/${libexecdir}
    install -d ${D}/${bindir}
    install -m 0755  ${S}/FreonDemo ${D}/${libexecdir}
    install -m 0755  ${WORKDIR}/freondemo ${D}/${bindir}
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/freondemo.init ${D}${sysconfdir}/init.d/freondemo
}

INITSCRIPT_NAME = "freondemo"
INITSCRIPT_PARAMS = "defaults 99"
