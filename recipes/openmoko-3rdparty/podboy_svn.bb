DESCRIPTION = "A podcast aggregator/player"
HOMEPAGE = "http://code.google.com/p/podboy/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"

SRCREV = "210"
PV = "1.7.2+svnr${SRCPV}"
PR = "r3"

PACKAGE_ARCH = "all"

SRC_URI = "svn://podboy.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit distutils

FILES_${PN} += "${datadir}/podboy ${datadir}/applications/podboy.desktop ${datadir}/pixmaps/podboy.png"

DEPENDS = "edje-native ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugins-ugly', d)}"
RDEPENDS_${PN} += "python-compression python-elementary python-gst python-html python-netclient python-netserver python-sqlite3 python-subprocess gst-plugin-alsa gst-plugin-audioconvert gst-plugin-audioresample gst-plugin-bluez ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-mad', d)} gst-plugin-ogg gst-plugin-volume gst-plugin-vorbis"

do_compile_prepend() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/data ${S}/data/podboy.edc
}
