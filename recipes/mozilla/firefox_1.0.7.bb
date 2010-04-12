PR = "r2"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://xptcstubs.patch;patch=1 \
	file://no-xmb.patch;patch=1 \
	file://firefox-cc-fix.patch;patch=1 \
	file://jsautocfg.h \
	file://extensions-hack.patch;patch=1 \
	file://firefox-1.0-gcc4-compile.patch;patch=1;pnum=0 \
	file://xptcinvoke-arm.patch;patch=1 \
	file://mozilla-eabi.patch;patch=1"
S = "${WORKDIR}/mozilla"

inherit autotools mozilla
	
require firefox.inc

EXTRA_OECONF += " --with-gssapi=${STAGING_LIBDIR}/../"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
}

SRC_URI[md5sum] = "5704a8c36de84b408e069afb0c5bc1df"
SRC_URI[sha256sum] = "10056021004ae378baed886358dc4468af60eafbaa9fcac93401e4db9b9ef7fd"
