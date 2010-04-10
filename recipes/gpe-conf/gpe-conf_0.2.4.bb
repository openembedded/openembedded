DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ esound audiofile libgpewidget libxsettings libxsettings-client libxrandr"
RDEPENDS_${PN} = "xst xset ntpdate gpe-login gpe-icons tzdata xrandr"
RDEPENDS_gpe-conf-panel = "gpe-conf"

PR = "r2"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

SRC_URI += "file://scriptname.patch;patch=1;pnum=0"

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"



SRC_URI[md5sum] = "c8685a71cfba4a78dd7eecd29e52fa72"
SRC_URI[sha256sum] = "ffdc3070784c50487c0463d2c166da340f6f94eede18c37883c6c5bac3d5338b"
