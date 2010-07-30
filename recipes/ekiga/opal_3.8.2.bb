DESCRIPTION = "Open Phone Abstraction Library, implementation of the ITU H.323 teleconferencing protocol, and successor of the openh323 library."
LICENSE = "MPL"

PR = "r2"

inherit gnome

DEPENDS += " ffmpeg ptlib virtual/libsdl openldap"
SRC_URI = "http://garr.dl.sourceforge.net/project/opalvoip/v3.8%20Sirius/Stable%202/opal-${PV}.tar.bz2;name=opal \
          "
SRC_URI[opal.md5sum] = "dff4204187f4a43ea8c2be376ea6155b"
SRC_URI[opal.sha256sum] = "a699f4c3710a2ddb5ae9a6cba0e303bbd29a94ed011f642b7763729a61598c7c"

EXTRA_OECONF = "--enable-localgsm --disable-spandsp "
ARM_INSTRUCTION_SET = "arm"

TARGET_CC_ARCH += "${LDFLAGS}"
TARGET_CC_ARCH += "-D__STDC_CONSTANT_MACROS"

do_configure() {
	libtoolize --force
	gnu-configize
	oe_runconf
}

FILES_${PN} += "${libdir}/opal-${PV}/*/*.so ${libdir}/opal-${PV}/*/*/*.so"
FILES_${PN}-dbg += "${libdir}/opal-${PV}/*/.debug ${libdir}/opal-${PV}/*/*/.debug"
