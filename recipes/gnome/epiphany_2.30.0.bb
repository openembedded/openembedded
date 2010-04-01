DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "libsoup-2.4 gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"

inherit gnome

SRC_URI[archive.md5sum] = "c78e40f61dae39b490fcf94e296aa239"
SRC_URI[archive.sha256sum] = "2e403ab0fe04575575fa99cdb6b3007007fa8e961e2c2fd4308b13e27bbf58d4"

EXTRA_OECONF = "--disable-nss --with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"


