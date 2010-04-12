DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "libsoup-2.4 gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"
PR = "r1"

inherit gnome


EXTRA_OECONF = "--with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"



SRC_URI[archive.md5sum] = "d46089988045c17adaa70af963b3e47a"
SRC_URI[archive.sha256sum] = "aafb7b16fd23e34315d511c0568e8c4d680be93e2547e8f18dfa4471bc0a6a0b"
