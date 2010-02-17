DESCRIPTION = "ConsoleKit is a framework for defining and tracking users, login sessions, and seats."
LICENSE = "GPLv2"
DEPENDS = "policykit dbus ${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"

PR = "r1"

inherit gnome

SRC_URI = "http://www.freedesktop.org/software/ConsoleKit/dist/ConsoleKit-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "48eda4483cc97841d5f88e8e003eb6d7"
SRC_URI[archive.sha256sum] = "f032adc6146d745034315054c5822a7a09f30e20a40d6e802221fa977354403e"

S = "${WORKDIR}/ConsoleKit-${PV}"

EXTRA_OECONF = " ${@base_contains('DISTRO_FEATURES', 'pam', '--enable-pam-module --with-pam-module-dir=${libdir}/security', '--disable-pam-module', d)} "

FILES_${PN} += "${libdir}/ConsoleKit ${datadir}/dbus-1 ${datadir}/PolicyKit ${datadir}/polkit* ${libdir}/security/pam_ck_connector.so"




