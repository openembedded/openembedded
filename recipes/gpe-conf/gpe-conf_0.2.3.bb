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

SRC_URI[md5sum] = "beec965857c6fb5f55dd2a322cae7e37"
SRC_URI[sha256sum] = "75bfe61f49bad95ff4220581c04af4fa3617cb639d98141d833e6aef68b77468"
