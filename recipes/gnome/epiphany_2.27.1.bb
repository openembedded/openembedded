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



SRC_URI[archive.md5sum] = "840fb2dc0511039de378927e3bccd802"
SRC_URI[archive.sha256sum] = "36d2b3652b5bbf7b459fda95ac0f25c429aa2e05e42fede3e88ce463879bdb8b"
