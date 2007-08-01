SECTION = "x11"
DESCRIPTION = "Sato Icon Theme"
LICENSE = "CC-BY-SA3"
DEPENDS = ""

PACKAGE_ARCH = "all"

SRC_URI = "http://pokylinux.org/releases/sato/sato-icon-theme-${PV}.tar.gz"

inherit autotools pkgconfig

pkg_postinst_${PN} () {
        if [ "x$D" != "x" ]; then
                exit 1
        fi
        gtk-update-icon-cache -q /usr/share/icons/Sato
}

FILES_${PN} += "${datadir}"

