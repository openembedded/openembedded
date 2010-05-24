PR = "r2"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://xptcstubs.patch;apply=yes \
	file://no-xmb.patch;apply=yes \
	file://firefox-cc-fix.patch;apply=yes \
	file://jsautocfg.h \
	file://extensions-hack.patch;apply=yes \
	file://firefox-1.0-gcc4-compile.patch;apply=yes;striplevel=0 \
	file://xptcinvoke-arm.patch;apply=yes \
	file://mozilla-eabi.patch;apply=yes"
S = "${WORKDIR}/mozilla"

inherit autotools mozilla
	
require firefox.inc

EXTRA_OECONF += " --with-gssapi=${STAGING_LIBDIR}/../"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
}

SRC_URI[md5sum] = "5704a8c36de84b408e069afb0c5bc1df"
SRC_URI[sha256sum] = "10056021004ae378baed886358dc4468af60eafbaa9fcac93401e4db9b9ef7fd"
