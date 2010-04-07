DESCRIPTION = "Enna is a media center application based on EFL."
HOMEPAGE = "http://${PN}.geexbox.org/"
SECTION = "x11/multimedia"
LICENSE = "LGPLv2.1+"
DEPENDS = "curl eet evas edje ecore edbus elementary emotion"
DEPENDS += "libxml2 libvalhalla libplayer"

INC_PR = "r1"

SRC_URI = "http://${PN}.geexbox.org/releases/${P}.tar.bz2;name=${PN}"

inherit autotools pkgconfig

do_configure_prepend() {
	autopoint || touch config.rpath
}
