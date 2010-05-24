DEPENDS += "cairo"
PR = "r1"

# Fails to build with gcc 4.3.x due to wchar problems:
# /OE/angstrom-dev/cross/armv7a/lib/gcc/arm-angstrom-linux-gnueabi/4.3.1/../../../../arm-angstrom-linux-gnueabi/bin/ld: ERROR: mozilla-xremote-client.o: Conflicting definitions of wchar_t
DEFAULT_PREFERENCE = "-1"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://jsautocfg.h \
	file://security-cross.patch \
	file://jsautocfg-dontoverwrite.patch \
	file://Bug339782.additional.fix.diff \
	file://Bug385583.nspr.jmp_buf.eabi.diff \
	file://Bug405992.atomic.nspr.diff \
	file://jemalloc-tls.patch \
	file://0001-Remove-Werror-from-build.patch \
	file://0002-Fix-security-cross-compile-cpu-detection-error.patch \
	file://plugins-dir.patch \
"

S = "${WORKDIR}/mozilla"

inherit mozilla
require firefox.inc

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
	sed -i "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" security/coreconf/Linux.mk
}

do_stage() {
        install -d ${STAGING_INCDIR}/firefox-${PV}
        cd dist/sdk/include
		rm -rf obsolete
        headers=`find . -name "*.h"`
        for f in $headers
        do
                install -D -m 0644 $f ${STAGING_INCDIR}/firefox-${PV}/
        done
        # removes 2 lines that call absent headers
        sed -e '178,179d' ${STAGING_INCDIR}/firefox-${PV}/nsIServiceManager.h
}

SRC_URI[md5sum] = "5fb6c6f3e973516df83a573348377a2f"
SRC_URI[sha256sum] = "e0c279546d99d3d21c30cdae6649e0d3710a5db44edd1347b4f31e04cb729040"
