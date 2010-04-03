DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ntp gpe-login gpe-icons"
RDEPENDS_${PN} = "xst tzdata xset ntpdate gpe-login gpe-icons"
RDEPENDS_gpe-conf-panel = "gpe-conf"

inherit autotools gpe

SRCREV = "9900"
PV = "0.2.8+svnr${SRCPV}"
PR = "r0"

SRC_URI = "${GPE_SVN}"
S = "${WORKDIR}/${PN}"


PACKAGES = "${PN}-dbg gpe-conf gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"

