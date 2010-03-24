DEPENDS += "cairo sqlite3 libnotify"

# The .pc files below have "3.6" hardcoded, fix that before using them in a newer FF version!
SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}.source.tar.bz2;name=archive \
	file://jsautocfg.h \
	file://security-cross.patch;patch=1 \
	file://Bug339782.additional.fix.diff;patch=1 \
	file://Bug385583.nspr.jmp_buf.eabi.diff;patch=1 \
	file://Bug405992.atomic.nspr.diff;patch=1 \
	file://jemalloc-tls.patch;patch=1 \
	file://0001-Remove-Werror-from-build.patch;patch=1 \
	file://0002-Fix-security-cross-compile-cpu-detection-error.patch;patch=1 \
	file://plugins-dir.patch;patch=1 \
	file://firefox-plugin.pc \
	file://firefox-xpcom.pc \
	file://nspr.pc \
"

SRC_URI[archive.md5sum] = "a1972a2216ac7139b92b7378a328ec93"
SRC_URI[archive.sha256sum] = "0f8398efabb14da83e14c7fbabdff99a619752cadb43348b27adf302382046f0"

S = "${WORKDIR}/mozilla-1.9.2"

inherit mozilla
require firefox.inc

EXTRA_OECONF += " --enable-official-branding --disable-crashreporter"


FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
	sed -i "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" security/coreconf/Linux.mk
}

