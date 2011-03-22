DESCRIPTION = "Mozilla Mobile browser"

PV = "2.0+${MOZPV}"
MOZPV = "4.0b5"
PR = "r0"
PE = "1"
SRCREV = "FENNEC_4_0b5_RELEASE"
SRC_URI = "hg://hg.mozilla.org;module=mozilla-central;rev=${SRCREV} \
           hg://hg.mozilla.org;module=mobile-browser;rev=${SRCREV} \
           file://fennec-uclibc.patch \
           file://libffi-arm-softfloat.patch \
           file://uclibc-isfinite.patch \
           file://cross-config.patch \
           file://jsautocfg.h \
           file://jsautocfg-dontoverwrite.patch \
"

S = "${WORKDIR}/mozilla-central"

inherit mozilla
require firefox.inc

DEPENDS += "yasm-native libnotify autoconf213-native cairo alsa-lib sqlite3 mesa gconf"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

export LIBXUL_DIST="${S}/objdir/xulrunner/dist/"

CFLAGS_append = " -DMOZ_GFX_OPTIMIZE_MOBILE "

# We need to append -L<sysroot>/usr/lib to LDFLAGS otherwise
# it starts picking dependencies from /usr/lib if
# EXTRA_DSO_LDOPTS contains libraries like -lgconf-2
# then the make looks it up in VPATH and sysroot
# does not appear in VPATH and it wont find it if
# build host does not have a library in its /usr/lib
# 

LDFLAGS += "-L${STAGING_LIBDIR}"
#EXTRA_OEMAKE += "EXTRA_DSO_LDOPTS=-L${STAGING_LIBDIR}"

EXTRA_OECONF_append_arm = " --with-cpu-arch=${BASE_PACKAGE_ARCH} "

do_configure_prepend() {
	if [ -e ${WORKDIR}/mobile-browser ] ; then
		mv ${WORKDIR}/mobile-browser ${S}/mobile
	fi	
	sed -i -e 's:head\ -1:head\ -n1:g' client.mk
	oe_runmake -f client.mk CONFIGURE_ARGS="${EXTRA_OECONF}" configure
}

do_compile_prepend() {
	# A compile time assert is broken:
	# http://mxr.mozilla.org/mozilla-central/source/nsprpub/pr/include/prlog.h#259
	for i in $(find ${S} -name "autoconf.mk") ; do 
		sed -i -e s:fsigned-char:fno-signed-char:g $i
	done

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
	rm ${D}/${libdir}/fennec/xulrunner/nsinstall ||true
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/mozilla-${PN}.desktop ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/mozilla-${PN}.png ${D}${datadir}/pixmaps/
}

FILES_${PN} += "${libdir}/fennec" 
