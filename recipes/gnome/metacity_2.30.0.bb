DEFAULT_PREFERENCE = "-1"

SECTION = "x11/wm"
DESCRIPTION = "Metacity is the boring window manager for the adult in you."
LICENSE = "GPL"
DEPENDS = "libcanberra libwnck startup-notification gtk+ gconf gdk-pixbuf-csource-native"

inherit gnome update-alternatives

SRC_URI += "file://crosscompile.patch;patch=1 "

SRC_URI[archive.md5sum] = "7c8a4c8f3b667efcc60f286adb445d4c"
SRC_URI[archive.sha256sum] = "5c4e2af2216de022181f692f15427361a1dae3d30756ef89b97a11ff5bd50b22"

EXTRA_OECONF += "--disable-verbose \
                 --disable-xinerama \
                 --without-introspectiom \
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
