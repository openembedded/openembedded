DESCRIPTION = "gnome system tools backends"
LICENSE = "GPL"

PR = "r1"

DEPENDS = "dbus dbus-glib glib-2.0 policykit"

# Shadow added so there is a full adduser/deluser
# (Gnome images tend to pull in shadow anyway)
RDEPENDS_${PN} = "shadow"

inherit gnome pkgconfig update-rc.d gettext

SRC_URI[archive.md5sum] = "bde46137761df8849d6ee176449f84f5"
SRC_URI[archive.sha256sum] = "0c1cfdf5f0550c0ccacbbc4f00ed059ab9ea483d48138132db44b3a20575d7b4"

SRC_URI += " \
            file://system-tools-backends \
	    file://dont-automake.patch \
           "

SRC_URI_append_angstrom = " \
            file://add-angstrom-distro.patch \
           "

EXTRA_OECONF = " --with-net-dbus=${libdir}/perl5 "

do_configure() {
	sed -i -e 's:CC=$(CC):CC="$(CC)":g' ${S}/Net-DBus/Makefile.am
	sed -i -e 's:CC=$(CC):CC="$(CC)":g' ${S}/Net-DBus/Makefile.in
	libtoolize --force --install
	aclocal
    gnu-configize
	oe_runconf
	cp ${STAGING_BINDIR_CROSS}/${TARGET_PREFIX}libtool ${S}
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
FILES_${PN} += " ${datadir}/polkit*"
