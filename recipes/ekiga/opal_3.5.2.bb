DESCRIPTION = "Open Phone Abstraction Library, implementation of the ITU H.323 teleconferencing protocol, and successor of the openh323 library."
LICENSE = "MPL"

PR = "r2"

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

