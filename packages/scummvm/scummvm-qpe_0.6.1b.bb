include scummvm.inc 
DEPENDS = "libsdl-qpe libmad tremor libogg zlib libmpeg2"

S=${WORKDIR}/scummvm-${PV}/

do_compile() {
	oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LDFLAGS="${LDFLAGS} -lmpeg2" \
                   DEFINES="-DUNIX -DSCUMM_NEED_ALIGNMENT -DQTOPIA -DUSE_MAD -DUSE_VORBIS -DUSE_ZLIB -DUSE_MPEG2"
}

