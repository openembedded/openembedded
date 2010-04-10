DESCRIPTION = "Open Phone Abstraction Library, implementation of the ITU H.323 teleconferencing protocol, and successor of the openh323 library."
LICENSE = "MPL"

inherit gnome

DEPENDS += " ffmpeg ptlib virtual/libsdl openldap"

SRC_URI = "http://www.ekiga.org/admin/downloads/latest/sources/ekiga_3.0.2/opal-${PV}.tar.bz2 \
           file://configure.diff;patch=1 \
          "

EXTRA_OECONF = "--enable-localgsm --disable-spandsp "

do_configure() {
	libtoolize --force
	gnu-configize
	oe_runconf
}

FILES_${PN} += "${libdir}/opal-${PV}/*/*.so ${libdir}/opal-${PV}/*/*/*.so"
FILES_${PN}-dbg += "${libdir}/opal-${PV}/*/.debug ${libdir}/opal-${PV}/*/*/.debug"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "01e76bc1261ab6c5b537387a81e7fdd9"
SRC_URI[sha256sum] = "3ed39e1dc74b4e1adb3d8a3430b18bcfd19d21406375faf420cbdcd5499a4594"
