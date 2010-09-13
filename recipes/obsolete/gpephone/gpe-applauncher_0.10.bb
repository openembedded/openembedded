LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "0"

PACKAGES += "gpe-applauncher-config"
PACKAGE_ARCH_gpe-applauncher-config_om-gta01 = "${MACHINE_ARCH}"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libsettings libxsettings-client"
RDEPENDS_${PN} += "gpe-applauncher-config"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

SRC_URI += "file://hotkeys.conf"

FILES_${PN} = '${datadir} ${bindir}'
FILES_gpe-applauncher-config = '${sysconfdir}/gpe/'

do_configure_append () {
	install ${WORKDIR}/hotkeys.conf ${S}
}

SRC_URI[md5sum] = "466f9316024ed82ee1921b56376f04ce"
SRC_URI[sha256sum] = "916ef522cbd2af8cc9623c2e4a34a8d1e45f9852bbb63a40ac056ba2c773eada"
