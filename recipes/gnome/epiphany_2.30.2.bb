DESCRIPTION = "GNOME default webbrowser"
LICENSE = "GPLv2+"
DEPENDS = "libsoup-2.4 gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification ca-certificates"
RDEPENDS_${PN} = "gnome-vfs-plugin-http iso-codes"
RRECOMMENDS_${PN} = "ca-certificates"
PR = "r4"

inherit gnome

SRC_URI[archive.md5sum] = "29b084acfa016540d91d3601ec3dff5c"
SRC_URI[archive.sha256sum] = "cd0124e71e72142593cfeb442d58d97e99ba94ace6e31d94717fe977c0bfb98a"


EXTRA_OECONF += "--disable-nss --with-engine=webkit --with-distributor-name=${DISTRO} --without-ca-file"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"


