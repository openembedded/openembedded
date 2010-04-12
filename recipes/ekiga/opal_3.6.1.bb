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


SRC_URI[md5sum] = "c2b4f12822cef2182267ea0d020bddf6"
SRC_URI[sha256sum] = "e6b48a294b35449c851c2a6ea6969041ed7f4148e92b3faa03a330b7bb5a59af"
