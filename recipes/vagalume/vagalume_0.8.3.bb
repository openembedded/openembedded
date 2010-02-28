DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://vagalume.igalia.com/"
SECTION = "x11"
DEPENDS = "gtk+ gstreamer curl gst-plugins-good ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugins-ugly', d)}"
RDEPENDS = "curl gst-plugin-autodetect gst-plugin-audioconvert gst-plugin-alsa gst-plugin-gconfelements librsvg-gtk ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-mad', d)}"
RRECOMMENDS = "dbus-x11 hicolor-icon-theme"
PR = "r0"

SRC_URI = "http://vagalume.igalia.com/files/source/vagalume_${PV}.orig.tar.gz\
	   file://index.theme \
	  "
S = "${WORKDIR}/${P}.orig"
inherit autotools

FILES_${PN} += "${datadir}/icons ${datadir}/dbus-1"

do_install_append() {
	install -m 0644 ${WORKDIR}/index.theme ${D}${datadir}/vagalume/icons/hicolor
}
