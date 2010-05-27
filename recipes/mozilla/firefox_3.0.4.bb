DEPENDS += "cairo"
PR = "r1"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://jsautocfg.h \
	file://security-cross.patch \
	file://jsautocfg-dontoverwrite.patch \
	file://Bug339782.additional.fix.diff \
	file://Bug385583.nspr.jmp_buf.eabi.diff \
	file://Bug405992.atomic.nspr.diff \
	file://random_to_urandom.diff \
	file://jemalloc-tls.patch \
	file://0001-Remove-Werror-from-build.patch \
	file://0002-Fix-security-cross-compile-cpu-detection-error.patch \
	file://plugins-dir.patch \
"

S = "${WORKDIR}/mozilla"

# This is missing the wchart.diff patch and can't be compiled with a recent gcc
DEFAULT_PREFERENCE = "-1"

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

SRC_URI[md5sum] = "8a1ac4a5940108a96458c5307a74c98d"
SRC_URI[sha256sum] = "685df7c7f33fc71a8c2d0fb71e190d59e2dd92007c2ace1ad176e655fb3012d7"
