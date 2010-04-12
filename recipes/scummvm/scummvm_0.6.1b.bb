require scummvm.inc
DEPENDS = "virtual/libsdl tremor libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"
SRC_URI += " file://mouse.patch;patch=1 \
             file://gcc-4.x.x-accept.patch;patch=1 \
	     file://sh3-linux-new-arch.patch;patch=1 \
	     file://tail-obselete-fix.patch;patch=1 \
	     file://tremor.patch;patch=1"


SRC_URI[md5sum] = "143dd7cfe0995922c49e1f8a6cdf2055"
SRC_URI[sha256sum] = "29007f54d9e5a37a3da9f51670de7828dde9a3559beddbdd5c2f59796fb220f6"
