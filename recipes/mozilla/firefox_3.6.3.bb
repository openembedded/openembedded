DEPENDS += "cairo sqlite3 libnotify"

# The .pc files below have "3.6" hardcoded, fix that before using them in a newer FF version!
SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}.source.tar.bz2;name=archive \
	file://jsautocfg.h \
	file://security-cross.patch \
	file://Bug339782.additional.fix.diff \
	file://Bug385583.nspr.jmp_buf.eabi.diff \
	file://Bug405992.atomic.nspr.diff \
	file://jemalloc-tls.patch \
	file://0001-Remove-Werror-from-build.patch \
	file://0002-Fix-security-cross-compile-cpu-detection-error.patch \
	file://plugins-dir.patch \
	file://firefox-plugin.pc \
	file://firefox-xpcom.pc \
	file://nspr.pc \
"

SRC_URI[archive.md5sum] = "5e4541ab23084b7b14ba228291ce2688"
SRC_URI[archive.sha256sum] = "35a0b35d79baa502b6c5781ed3e9c4b5eb623bdaf1940460dcf465192848a2d0"

S = "${WORKDIR}/mozilla-1.9.2"

inherit mozilla
require firefox.inc

EXTRA_OECONF += " --enable-official-branding --disable-crashreporter"


FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
	sed -i "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" security/coreconf/Linux.mk
}

