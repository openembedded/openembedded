DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
HOMEPAGE = "http://www.emma-soft.com/projects/epdfview/"
LICENSE = "GPLv2"
DEPENDS = "poppler gtk+"

SRC_URI = "http://www.emma-soft.com/projects/epdfview/chrome/site/releases/epdfview-${PV}.tar.bz2"

PR="r0"

inherit autotools

do_compile_append () {
	sed -i 's|\$.*prefix./|/usr/|' data/epdfview.desktop
}

