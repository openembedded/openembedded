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
