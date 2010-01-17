DEPENDS += "cairo"
PR = "r3"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}-source.tar.bz2 \
	file://xptcstubs.patch;patch=1 \
	file://no-xmb.patch;patch=1 \
	file://jsautocfg.h \
	file://extensions-hack.patch;patch=1 \
	file://security-cross.patch;patch=1 \
	file://jsautocfg-dontoverwrite.patch;patch=1 \
	file://xptcinvoke-arm.patch;patch=1 \
	file://eabi-fix.patch;patch=1 \
	file://eabi-fix2.patch;patch=1 \
	file://eabi-fix3.patch;patch=1 \
	file://linkage-problem.patch;patch=1 \
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
