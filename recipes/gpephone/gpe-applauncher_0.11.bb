LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r2"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "0"

PACKAGES += "gpe-applauncher-config"
PACKAGE_ARCH_gpe-applauncher-config_om-gta01 = "${MACHINE_ARCH}"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libsettings libxsettings-client"
RDEPENDS_${PN} += "gpe-applauncher-config"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

SRC_URI += "file://hotkeys.conf \
            file://softkeys.conf"

EXTRA_OECONF = "--enable-gridlayout"

FILES_${PN} = '${datadir} ${bindir}'
FILES_gpe-applauncher-config = '${sysconfdir}/gpe/'

do_configure_append () {
    install ${WORKDIR}/hotkeys.conf ${S}
    install ${WORKDIR}/softkeys.conf ${S}
}

SRC_URI[md5sum] = "e02616d1fbbeb441187f3e2db17517ca"
SRC_URI[sha256sum] = "a5186b3099643f74e41e2a805489df8edc453bf1ab6eae1cef821a5b814e5035"
