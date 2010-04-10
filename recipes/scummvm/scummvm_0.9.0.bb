require scummvm.inc
DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"
SRC_URI += "file://sh3-arch-0.9.0+.patch;patch=1"

EXTRA_OECONF += "--enable-lure \
		 --enable-agi \
		 --enable-cine \
		 "

SRC_URI[md5sum] = "5eede9c97d1883f80770a3e211419783"
SRC_URI[sha256sum] = "5824f67aa37b00fc8b92ac4fcc413a9a7d868174dcd6df580c4d706807e4545e"
