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


SRC_URI[md5sum] = "43b363c860780e7f1a0361cfee8f9f4a"
SRC_URI[sha256sum] = "60c9d75703bedfeca7140cb76b23fae7179ce1f86e7e8b0026b72d66acd75c82"
