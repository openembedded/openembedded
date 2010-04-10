DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "libsoup-2.4 gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"

PR = "r2"

inherit gnome


EXTRA_OECONF = "--with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"



SRC_URI[archive.md5sum] = "f3354751f7e293c03ffb9f26bd00b17f"
SRC_URI[archive.sha256sum] = "6faf0aaf8a44ad119baa921a634eb8dd2d02c4f501af176f294164f7d49dca5e"
