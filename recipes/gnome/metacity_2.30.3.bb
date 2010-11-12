SECTION = "x11/wm"
DESCRIPTION = "Metacity is the boring window manager for the adult in you."
LICENSE = "GPL"
DEPENDS = "libcanberra libwnck startup-notification gtk+ gconf gdk-pixbuf-csource-native gnome-doc-utils"

inherit gnome update-alternatives

PR = "r1"

SRC_URI += "file://crosscompile.patch;apply=yes \
	file://add-disable-canberra-flag.patch;apply=yes \
"

SRC_URI[archive.md5sum] = "553784f376d96b902e19ff437cd5b339"
SRC_URI[archive.sha256sum] = "08f887018fa5e447cf184d03bae3fe2c05fdb7583bed6768e3b4d66392fc18dd"

EXTRA_OECONF += "--disable-verbose \
                 --disable-xinerama \
"

do_configure_prepend() {
	sed -i -e 's:$ZENITY:$NOZENITY:g' -e 's:-Werror::g' ${S}/configure.in
}

EXTRA_OEMAKE = ' STAGING_INCDIR_NATIVE="${STAGING_INCDIR_NATIVE}" STAGING_LIBDIR_NATIVE="${STAGING_LIBDIR_NATIVE}"'

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/metacity"
ALTERNATIVE_PRIORITY = "30"

RDEPENDS_${PN} = "zenity"
FILES_${PN} += "${datadir}/themes ${datadir}/gnome*"
