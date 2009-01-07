DESCRIPTION = "libv4l is a collection of libraries which adds a thin abstraction layer on top of video4linux2 devices."
LICENSE = "LGPLv2"

SRC_URI = "http://people.atrpms.net/~hdegoede/libv4l-${PV}.tar.gz"

inherit pkgconfig

export PREFIX="${prefix}"

do_install() {
	oe_runmake DESTDIR="${D}" install
}

do_stage() {
	oe_runmake DESTDIR="${STAGING_DIR_TARGET}" install
}
