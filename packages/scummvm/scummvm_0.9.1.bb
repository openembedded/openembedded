DEFAULT_PREFERENCE = "-1"

require scummvm.inc
DEPENDS = "virtual/libsdl libmad libvorbis libogg zlib mpeg2dec"

EXTRA_OECONF += "--enable-lure \
		 --enable-agi \
		 --enable-cine \
		 "

do_compile() {
	oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LDFLAGS="${LDFLAGS} -lmpeg2" \
                   DEFINES="-DUNIX -DSCUMM_NEED_ALIGNMENT  -DUSE_MAD -DUSE_VORBIS -DUSE_ZLIB -DUSE_MPEG2"
}


