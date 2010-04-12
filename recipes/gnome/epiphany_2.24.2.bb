DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "libsoup-2.4 gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"

inherit gnome

PR = "r2"

EXTRA_OECONF = "--with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"



SRC_URI[archive.md5sum] = "7650df6cc08292cd6faf8bbcfbf9e901"
SRC_URI[archive.sha256sum] = "6cf629d628ee2ae908c9aa3c530fa05344dfe47a9b770c1d9d1e7cc16d7528b3"
