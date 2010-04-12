DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ esound audiofile libgpewidget libxsettings libxsettings-client libxrandr"
RDEPENDS_${PN} = "xst gpe-confd xset ntpdate gpe-icons tzdata xrandr"
RDEPENDS_gpe-conf-panel = "gpe-conf"

RPROVIDES_${PN} += " bl"
RCONFLICTS_${PN} = "bl"

PR = "r2"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

SRC_URI += "file://poweroff.patch;patch=1 \
            file://wifi-key.patch;patch=1;pnum=0"

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"


SRC_URI[md5sum] = "7fe086de357f209df9413fb07a515724"
SRC_URI[sha256sum] = "f69273239546ea212f862e0c86a8288f63dad78359ce3c1081b98bddd778b378"
