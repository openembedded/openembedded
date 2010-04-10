DESCRIPTION = "GNOME frontend for packagekit"
LICENSE = "GPL"

DEPENDS = "packagekit libsexy gconf-dbus policykit policykit-gnome libunique gnome-menus devicekit-power"

inherit gnome

SRC_URI = "http://www.packagekit.org/releases/gnome-packagekit-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "3282c845c2b7a9e157f84a919c7a0105"
SRC_URI[archive.sha256sum] = "2697d9374a3f7f3e32063f22292b0fd1e478d0273af6de62d8f4809118478c93"

EXTRA_OECONF = " --enable-compile-warnings=no  --disable-scrollkeeper "

do_configure_prepend() {
	sed -i -e s/help/docs/ Makefile.am 
	sed -i -e s:-Werror::g configure.ac
}

FILES_${PN} += "${datadir}/icons ${datadir}/gnome"
