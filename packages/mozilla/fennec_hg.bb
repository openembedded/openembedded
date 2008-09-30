DESCRIPTION = "Mozilla Mobile browser"
DEPENDS += "cairo alsa-lib "

PV = "0.8+0.9pre"
MOZPV = "0.9pre"
PR = "r8"
PE = "1"

SRC_URI = "hg://hg.mozilla.org/;module=mozilla-central;rev=aa4d3083995f \
           hg://hg.mozilla.org/;module=mobile-browser;rev=31f56bf4590a \
           file://jsautocfg.h \
           file://jsautocfg-dontoverwrite.patch;patch=1 \
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
	cp ${WORKDIR}/jsautocfg.h ${S}/objdir/xulrunner/js/src/
	sed -i -e "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" \
	       -e  s:'$(OS_TEST)':${TARGET_ARCH}:g \
	           ${S}/security/coreconf/Linux.mk

	sed -i -e /LIBXUL_DIST/d \ 
	       -e /LIBXUL_SDK/d \   
		  ${S}/objdir/mobile/config/autoconf.mk

	echo "LIBXUL_DIST	 = ${S}/objdir/xulrunner/dist" >> ${S}/objdir/mobile/config/autoconf.mk
	echo "LIBXUL_SDK	 = ${S}/objdir/xulrunner/dist" >> ${S}/objdir/mobile/config/autoconf.mk
}


do_install() {
	cd ${S}/objdir/mobile/
	oe_runmake package
	install -d ${D}/${libdir}
	tar xjf ${S}/objdir/mobile/dist/fennec-${MOZPV}*.tar.bz2 -C ${D}/${libdir}
	# remove x86 binary
	rm ${D}/${libdir}/fennec/xulrunner/nsinstall
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/mozilla-${PN}.desktop ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/mozilla-${PN}.png ${D}${datadir}/pixmaps/
}

do_stage() {
	:
}	


FILES_${PN} += "${libdir}/fennec" 

