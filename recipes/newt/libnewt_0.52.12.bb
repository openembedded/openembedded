DESCRIPTION = "Newt is a programming library for color text mode, widget based user interfaces"
HOMEPAGE = "https://fedorahosted.org/newt/"
SECTION = "libs"
LICENSE = "LGPL"

# slang needs to be >= 2.2
DEPENDS = "slang popt"

SRC_URI = "http://fedorahosted.org/releases/n/e/newt/newt-${PV}.tar.gz \
           file://support-DESTDIR.patch"
S = "${WORKDIR}/newt-${PV}"

inherit autotools

PACKAGES_prepend = "whiptail "

FILES_whiptail = "${bindir}/whiptail"

SRC_URI[md5sum] = "51b04128d9e1bf000fa769c417b74486"
SRC_URI[sha256sum] = "2ba88dc3d118daf509c58e3707c43ad57dd3415d8164054e93fe76439f348529"
