DESCRIPTION = "gnome system tools backends"
LICENSE = "GPL"

DEPENDS = "dbus dbus-glib glib-2.0 policykit"

inherit gnome pkgconfig update-rc.d

SRC_URI += " \
            file://angstrom.patch;patch=1 \
            file://system-tools-backends \
           "

do_configure_prepend() {
	sed -i -e /IT_PROG_INTLTOOL/d ${S}/configure.in
	sed -i -e /Makefile.in/d ${S}/configure.in
	sed -i -e 's: po : :g' ${S}/Makefile.am
	sed -i -e /policy/d ${S}/Makefile.am
	sed -i -e 's:org.freedesktop.SystemToolsBackends.service \\:org.freedesktop.SystemToolsBackends.service:g' ${S}/Makefile.am
	sed -i -e 's:@INTLTOOL_POLICY_RULE@::g' ${S}/Makefile.am
	sed -i -e 's:CC=$(CC):CC="$(CC)":g' ${S}/Net-DBus/Makefile.am
}

do_install_append () {
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/system-tools-backends ${D}/${sysconfdir}/init.d/	
}

INITSCRIPT_NAME = "system-tools-backends"
INITSCRIPT_PARAMS = "start 50 2 3 4 5 . stop 70 1 ."

FILES_${PN} += " ${sysconfdir}/dbus-1/system.d"
FILES_${PN} += " ${libdir}/pkgconfig"
FILES_${PN} += " ${datadir}/dbus-1/system-services"
FILES_${PN} += " ${datadir}/system-tools-backends-2.0/files"
FILES_${PN} += " ${datadir}/system-tools-backends-2.0/scripts"
