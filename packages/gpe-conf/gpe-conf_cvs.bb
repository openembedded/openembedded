DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ipaq-sleep ntp gpe-login gpe-icons"
RDEPENDS_${PN} = "xst xset ipaq-sleep ntpdate gpe-login gpe-icons"
RDEPENDS_gpe-conf-panel = "gpe-conf"

PV = "0.2.2+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"
S = "${WORKDIR}/${PN}"

inherit autotools gpe

PACKAGES = "gpe-conf gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"

