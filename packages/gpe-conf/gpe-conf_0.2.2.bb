LICENSE  = "GPL"
SECTION  = "gpe"
PRIORITY = "optional"

DEPENDS = "gtk+ esound-gpe audiofile libgpewidget libxsettings libxsettings-client xset ipaq-sleep ntpdate timezones"
RDEPENDS_${PN} = "xst xset ipaq-sleep ntpdate gpe-login gpe-icons timezones"
RDEPENDS_gpe-conf-panel = "gpe-conf"

MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
PR="r0"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"

FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"
