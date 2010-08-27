require kakasi.inc

DEPENDS = "kakasi-native"
DEPENDS_virtclass-native = ""

PR = "${INC_PR}.1"

SRC_URI[md5sum] = "4eff51aafbd56c9635791a20c03efa8f"
SRC_URI[sha256sum] = "c272560f5c11fe45b011c4e26ada66218fb0109d5582c5876aa49c5e24718534"

do_install_virtclass-native() {
        install src/mkkanwa ${STAGING_BINDIR}
}

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"
