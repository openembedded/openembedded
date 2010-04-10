require kakasi.inc

SECTION = "utils"
DEPENDS = "kakasi-native"

SRC_URI += "file://makefile.patch;patch=1"

do_stage () {
        install -m 0644 lib/*.h ${STAGING_INCDIR}
	install lib/.libs/libkakasi.so* ${STAGING_LIBDIR}
}




SRC_URI[md5sum] = "4eff51aafbd56c9635791a20c03efa8f"
SRC_URI[sha256sum] = "c272560f5c11fe45b011c4e26ada66218fb0109d5582c5876aa49c5e24718534"
