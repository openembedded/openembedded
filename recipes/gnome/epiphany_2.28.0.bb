DESCRIPTION = "GNOME default webbrowser"
DEPENDS = "libsoup-2.4 gnome-desktop gnome-vfs libgnomeui webkit-gtk iso-codes startup-notification"
RDEPENDS = "gnome-vfs-plugin-http iso-codes"

inherit gnome

EXTRA_OECONF = "--disable-nss --with-engine=webkit --with-distributor-name=${DISTRO}"

do_configure_prepend() {
        touch ${S}/gnome-doc-utils.make
        sed -i -e s:help::g Makefile.am
}

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"



SRC_URI[archive.md5sum] = "b88ac1168fc271892cabf73b749cac16"
SRC_URI[archive.sha256sum] = "23e0379c41c378221338fb327d747f3e42b2b98cdf1512c9df7cbeab45f311ea"
