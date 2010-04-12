DESCRIPTION = "GNOME frontend for packagekit"
LICENSE = "GPL"

DEPENDS = "packagekit libsexy gconf policykit policykit-gnome libunique gnome-menus"

PR = "r2"

inherit gnome

SRC_URI = "http://www.packagekit.org/releases/gnome-packagekit-${PV}.tar.gz"

EXTRA_OECONF = " --enable-compile-warnings=no  --disable-scrollkeeper "

do_configure_prepend() {
	sed -i -e s/man// Makefile.am 
	sed -i -e s:-Werror::g configure.ac
}

FILES_${PN} += " \
                ${libdir} \
                ${datadir}/gnome \
                ${datadir}/icons \
               "

SRC_URI[md5sum] = "7a38bcdfda3e712365f674c51565e845"
SRC_URI[sha256sum] = "1d77646aa7291dcf8e5ab78955f5e5755faac982e795fa70f7ecf5aa98da6f9e"
