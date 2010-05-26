DEPENDS += "cairo"
PR = "r3"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://xptcstubs.patch \
	file://no-xmb.patch \
	file://jsautocfg.h \
	file://extensions-hack.patch \
	file://security-cross.patch \
	file://jsautocfg-dontoverwrite.patch \
	file://xptcinvoke-arm.patch \
	file://eabi-fix.patch \
	file://eabi-fix2.patch \
	file://eabi-fix3.patch \
	file://linkage-problem.patch \
"

S = "${WORKDIR}/mozilla"

DEFAULT_PREFERENCE = "-1"

inherit mozilla
require firefox.inc

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

SRC_URI[md5sum] = "24398e3d98673a2a92a01a8f771ca12a"
SRC_URI[sha256sum] = "02169e4e7a095c426fd5caf56c6cfc2415f4fe54cef7f4e78556f350e2c94007"
