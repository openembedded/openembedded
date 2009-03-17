require kakasi.inc

SECTION = "utils"
DEPENDS = "kakasi-native"

SRC_URI += "file://makefile.patch;patch=1"

do_stage () {
        install -m 0644 lib/*.h ${STAGING_INCDIR}
	install lib/.libs/libkakasi.so* ${STAGING_LIBDIR}
}



