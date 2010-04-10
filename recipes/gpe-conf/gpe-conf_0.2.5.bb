DESCRIPTION = "Configuration applets for GPE"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "gtk+ esound audiofile libgpewidget libxsettings libxsettings-client libxrandr"
RDEPENDS_${PN} = "xst xset ntpdate gpe-login gpe-icons tzdata xrandr"
RDEPENDS_gpe-conf-panel = "gpe-conf"

RPROVIDES_${PN} += " bl"
RCONFLICTS_${PN} = "bl"

PR = "r4"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig

PACKAGES += "gpe-conf-panel"

FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
                ${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
                ${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"

SRC_URI += "file://backlight-bugfix.patch;patch=1 \
            file://wireless.patch;patch=1"

SRC_URI[md5sum] = "11b9e8b7d7978fc44e5f079e7daa657f"
SRC_URI[sha256sum] = "6a246caeb7d29c2afb48e8c70ef8e1f2ba2a4642faeef3defd266522304d278b"
