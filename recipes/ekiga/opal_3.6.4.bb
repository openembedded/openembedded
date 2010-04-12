DESCRIPTION = "Open Phone Abstraction Library, implementation of the ITU H.323 teleconferencing protocol, and successor of the openh323 library."
LICENSE = "MPL"

inherit gnome

DEPENDS += " ffmpeg ptlib virtual/libsdl openldap"

SRC_URI = "${SOURCEFORGE_MIRROR}/opalvoip/opal-${PV}.tar.bz2 \
           file://configure.diff;patch=1 \
          "

EXTRA_OECONF = "--enable-localgsm --disable-spandsp "
ARM_INSTRUCTION_SET = "arm"

TARGET_CC_ARCH += "${LDFLAGS}"

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


SRC_URI[md5sum] = "d894c176818a33d34a04b21386798c4f"
SRC_URI[sha256sum] = "b1fb3bad0c8581b82f0da9c69673f43ad9aed7868a7e4f2a68c6c72ed656237b"
