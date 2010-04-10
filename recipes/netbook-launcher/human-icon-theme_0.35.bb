DEPENDS = "icon-naming-utils-native glib-2.0 intltool-native"

LICENSE = "CC-BY-SA"
RDEPENDS = "hicolor-icon-theme"
RRECOMMENDS = "librsvg-gtk"

inherit gnome

SRC_URI = "https://launchpad.net/ubuntu/lucid/+source/human-icon-theme/${PV}/+files/human-icon-theme_${PV}.tar.gz"

do_install_prepend() {
    sed -i -e s:/usr/lib/icon-naming-utils/:${STAGING_DIR_NATIVE}/${libexecdir}/:g Makefile
}

PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/*"

SRC_URI[md5sum] = "dd9bad3b7f95619a6536932300fe202a"
SRC_URI[sha256sum] = "d234a562fc4af10982b138b3e67e7f61f44b572d0493c776e639508e4faa0a29"
