DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://people.igalia.com/berto/"
SECTION = "x11"
DEPENDS = "gtk+ gstreamer"
RDEPENDS += "librsvg-gtk"
RRECOMMENDS = "dbus-x11"
PR = "r0"

SRC_URI = "\
  http://garage.maemo.org/frs/download.php/4505/vagalume_${PV}.orig.tar.gz\
  file://index.theme \
"
S = "${WORKDIR}/vagalume-${PV}.orig"

inherit autotools

do_install_append() {
	install -m 0644 ${WORKDIR}/index.theme ${D}${datadir}/vagalume/icons/hicolor
}

