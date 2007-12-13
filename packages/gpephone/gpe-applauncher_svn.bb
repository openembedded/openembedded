LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"
PV          = "0.11+svn-${SRCREV}"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "0"
DEFAULT_PREFERENCE = "-1"

inherit gpephone autotools
SRC_URI = "svn://projects.linuxtogo.org/svn/gpephone/trunk/source;module=${PN}"

S = "${WORKDIR}/${PN}"


PACKAGES += "gpe-applauncher-config"
PACKAGE_ARCH_gpe-applauncher-config_fic-gta01 = "${MACHINE_ARCH}"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libsettings libxsettings-client"
RDEPENDS_${PN} += "gpe-applauncher-config"


SRC_URI += "file://hotkeys.conf \
            file://softkeys.conf"

EXTRA_OECONF = "--enable-gridlayout"

FILES_${PN} = '${datadir} ${bindir}'
FILES_gpe-applauncher-config = '${sysconfdir}/gpe/'

do_configure_append () {
	install ${WORKDIR}/hotkeys.conf ${S}
	install ${WORKDIR}/softkeys.conf ${S}
}
