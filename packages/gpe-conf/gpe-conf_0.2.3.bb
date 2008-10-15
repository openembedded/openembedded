DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ esound audiofile libgpewidget libxsettings libxsettings-client"
RDEPENDS_${PN} = "xst xset ipaq-sleep ntpdate gpe-login gpe-icons tzdata"
RDEPENDS_gpe-conf-panel = "gpe-conf"

PR = "r1"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"
