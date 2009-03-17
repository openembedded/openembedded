require scummvm.inc
DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"
SRC_URI += "file://sh3-arch-0.9.0+.patch;patch=1"

EXTRA_OECONF += "--enable-lure \
		 --enable-agi \
		 --enable-cine \
		 "

do_compile() {
	oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" \
                   CXXFLAGS="${CXXFLAGS}" \
                   LDFLAGS="${LDFLAGS} ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '-lmpeg2', d)}" \
                   DEFINES="-DUNIX -DSCUMM_NEED_ALIGNMENT -DUSE_VORBIS -DUSE_ZLIB -DUSE_MPEG2 ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '-DUSE_MAD -DUSE_MPEG2', d}"
}


