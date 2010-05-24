DEPENDS += "cairo sqlite3 libnotify"

PR = "r4"

SRC_URI = "ftp://ftp.mozilla.org/pub/mozilla.org/firefox/releases/${PV}/source/firefox-${PV}.source.tar.bz2 \
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
	file://firefox-plugin.pc \
	file://firefox-xpcom.pc \
	file://nspr.pc \
"

S = "${WORKDIR}/mozilla-1.9.1"

inherit mozilla
require firefox.inc

EXTRA_OECONF += " --enable-official-branding --disable-crashreporter"


FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
	sed -i "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" security/coreconf/Linux.mk
}

do_stage() {
        install -d ${STAGING_INCDIR}/firefox-${PV}
        cd ${S}/dist/sdk/include
        cp -a obsolete ${STAGING_INCDIR}/firefox-${PV}/
        rm -rf obsolete
        headers=`find . -name "*.h"`
        for f in $headers
        do
                install -D -m 0644 $f ${STAGING_INCDIR}/firefox-${PV}/
        done
        cd ${S}/dist/include/plugin
        headers=`find . -name "*.h"`
        for f in $headers
        do
                install -D -m 0644 $f ${STAGING_INCDIR}/firefox-${PV}/
        done
        cd ${S}/nsprpub/pr/include
        headers=`find . -name "*.h"`
        for f in $headers
        do
                install -D -m 0644 $f ${STAGING_INCDIR}/firefox-${PV}/
        done
        cd ${S}/xpcom/base
        headers=`find . -name "*.idl"`
        for f in $headers
        do
                install -D -m 0644 $f ${STAGING_INCDIR}/firefox-${PV}/
        done

        for pc in ${WORKDIR}/*.pc ; do
            sed -i s:3.5.2:${PV}:g $pc
        done
        
        install -d ${PKG_CONFIG_DIR}
        install -m 0644 ${WORKDIR}/firefox-plugin.pc ${PKG_CONFIG_DIR}
        install -m 0644 ${WORKDIR}/firefox-xpcom.pc ${PKG_CONFIG_DIR}
        install -m 0644 ${WORKDIR}/nspr.pc ${PKG_CONFIG_DIR}
        install -m 0755 ${S}/xpcom/typelib/xpidl/host_xpidl ${STAGING_BINDIR_NATIVE}/xpidl

        # removes 2 lines that call absent headers
        sed -e '178,179d' ${STAGING_INCDIR}/firefox-${PV}/nsIServiceManager.h
}

SRC_URI[md5sum] = "b3d92dfb40584141dc1068efc9bdfccc"
SRC_URI[sha256sum] = "2abe7b5561267c230df27951d1d8c6c5853d06ca2426997fdf0a63c5db689feb"
