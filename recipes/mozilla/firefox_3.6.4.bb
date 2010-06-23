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

SRC_URI[archive.md5sum] = "66b1610362ed6009d66fe762645679a0"
SRC_URI[archive.sha256sum] = "fdea684a717c3eda111060994ead9deb33d0b77a11f0f15da0ebc138ca0b2ec8"

S = "${WORKDIR}/mozilla-1.9.2"

inherit mozilla
require firefox.inc

EXTRA_OECONF += " --enable-official-branding --disable-crashreporter"


FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
	sed -i "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" security/coreconf/Linux.mk
}

