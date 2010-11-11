DESCRIPTION = "Bug Labs icon theme"
LICENSE = "CC-BY-SA3"
SECTION = "x11/wm"

SRCREV="12121"

inherit autotools pkgconfig

SRC_URI = "svn://bugcamp.net/bug/trunk/com.buglabs.bug.theme;module=icons"

S = ${WORKDIR}/icons/Bug

DEPENDS = "icon-naming-utils-native"

FILES_${PN} = "${datadir}/icons"

PACKAGE_ARCH = "all"

pkg_postinst_${PN} () {
        if [ "x$D" != "x" ]; then
                exit 1
        fi
        gtk-update-icon-cache -q /usr/share/icons/Bug
}
