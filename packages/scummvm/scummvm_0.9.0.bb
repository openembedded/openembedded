require scummvm.inc
DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"
SRC_URI += "file://sh3-arch-0.9.0+.patch;patch=1"

EXTRA_OECONF += "--enable-lure \
		 --enable-agi \
		 --enable-cine \
		 "
