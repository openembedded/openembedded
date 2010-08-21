require flex.inc

PR = "${INC_PR}.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/flex/flex-${PV}.tar.bz2;name=flex \
"

SRC_URI[flex.md5sum] = "10714e50cea54dc7a227e3eddcd44d57"
SRC_URI[flex.sha256sum] = "0becbd4b2b36b99c67f8c22ab98f7f80c9860aec70f0350a0018f29a88704e7b"

do_install_append () {
	ln -sf flex ${D}${bindir}/lex
	ln -sf flex ${D}${bindir}/lex++
}

NATIVE_INSTALL_WORKS = "1"

# flex-2.5.35 adds a hard-coded path that causes failures when using packaged
# staging
PSTAGING_DISABLED_virtclass-native = "1"
