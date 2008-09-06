DEPENDS += "cairo"

PV = "0.0"
PR = "r1"

SRC_URI = "hg://hg.mozilla.org/;module=mozilla-central;rev=7352ef83055a \
           hg://hg.mozilla.org/;module=mobile-browser;rev=767c0315369c \
           file://jsautocfg.h \
"

S = "${WORKDIR}/mozilla-central"

inherit mozilla
require firefox.inc

PARALLEL_MAKE = ""
export HOST_LIBIDL_CONFIG = "${STAGING_BINDIR_NATIVE}/libIDL-config-2"
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

export LIBXUL_DIST="${S}/objdir/xulrunner/dist/"

do_configure_prepend() {
	if [ -e ${WORKDIR}/mobile-browser ] ; then
		mv ${WORKDIR}/mobile-browser ${S}/mobile
	fi	
	oe_runmake -f client.mk CONFIGURE_ARGS="${EXTRA_OECONF}" configure
}

do_compile_prepend() {
	cp ${WORKDIR}/jsautocfg.h ${S}/js/src/
	sed -i -e "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" \
	       -e  s:'$(OS_TEST)':${TARGET_ARCH}:g \
	           ${S}/security/coreconf/Linux.mk

	sed -i -e /LIBXUL_DIST/d ${S}/objdir/mobile/config/autoconf.mk
	echo "LIBXUL_DIST=${S}/objdir/xulrunner/dist" >> ${S}/objdir/mobile/config/autoconf.mk
}

do_stage() {
        install -d ${STAGING_INCDIR}/fennec-${PV}
        cd dist/sdk/include
		rm -rf obsolete
        headers=`find . -name "*.h"`
        for f in $headers
        do
                install -D -m 0644 $f ${STAGING_INCDIR}/fennec-${PV}/
        done
        # removes 2 lines that call absent headers
        sed -e '178,179d' ${STAGING_INCDIR}/fennec-${PV}/nsIServiceManager.h
}

