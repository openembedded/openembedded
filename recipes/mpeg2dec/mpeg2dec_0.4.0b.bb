DESCRIPTION = "Libraries and test programs for decoding mpeg-2 and mpeg-1 video streams"
HOMEPAGE = "http://libmpeg2.sourceforge.net/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2+"
DEPENDS = "virtual/libsdl"
PR = "r6"

SRC_URI = "http://libmpeg2.sourceforge.net/files/mpeg2dec-${PV}.tar.gz"
S = "${WORKDIR}/mpeg2dec-0.4.0"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-shared"

PACKAGES += "libmpeg2 libmpeg2-dev libmpeg2convert libmpeg2convert-dev"

FILES_${PN} = "${bindir}/*"
FILES_libmpeg2 = "${libdir}/libmpeg2.so.*"
FILES_libmpeg2convert = "${libdir}/libmpeg2convert.so.*"

SRC_URI[md5sum] = "52d10ea80595ec83d8557ba7ac6dc8e6"
SRC_URI[sha256sum] = "9416376952812e5b479745d67a2bf874fbcad10137517314ce7de37abb756df8"
