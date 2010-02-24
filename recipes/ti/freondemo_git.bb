DESCRIPTION = "FreonDemo: a QT based demo for OMAP L138 EVM board"
HOMEPAGE = "http://sourceforge.net/projects/freondemo"
MAINTAINER = "http://sourceforge.net/projects/freondemo"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

DEPENDS = "dbus gstd"
RDEPENDS_${PN} = "gstd alsa-utils-amixer gst-ipcsink"
RRECOMMENDS_${PN} = "qt4-embedded-plugin-mousedriver-tslib gstreamer-ti"

SRCREV = "19c4e201aa978d2b40793b9fa76cc4ddbff50016"

PV = "1.0"
PR = "r7"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://freondemo.git.sourceforge.net/gitroot/freondemo/freondemo;protocol=git \
           file://freondemo \
           file://freondemo.init \
           "
S = "${WORKDIR}/git"

inherit qt4e update-rc.d

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
