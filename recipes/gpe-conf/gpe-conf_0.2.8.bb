DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ esound audiofile libgpewidget libxsettings libxsettings-client libxrandr"
RDEPENDS_${PN} = "xst gpe-confd xset ntpdate gpe-icons tzdata xrandr"
RDEPENDS_gpe-conf-panel = "gpe-conf"

RPROVIDES_${PN} += " bl"
RCONFLICTS_${PN} = "bl"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"


SRC_URI[md5sum] = "faa798f698eead5f1fd31619b95e33ea"
SRC_URI[sha256sum] = "0f8c72783b2faf51c3f1a71dfedc0eab26097d7bf8924ebee7615bfce5725491"
