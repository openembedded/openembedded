DESCRIPTION = "Mozilla Mobile browser"
DEPENDS += "autoconf213-native cairo alsa-lib sqlite3"

PV = "3.4+3.5b4"
MOZPV = "3.5b4"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "hg://hg.mozilla.org/;module=mozilla-central;rev=8c9a6d851018 \
           file://jsautocfg.h \
           file://jsautocfg-dontoverwrite.patch;patch=1 \
"

S = "${WORKDIR}/mozilla-central"

inherit mozilla
require firefox.inc

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

export LIBXUL_DIST="${S}/objdir/xulrunner/dist/"
CFLAGS_append = " -DMOZ_GFX_OPTIMIZE_MOBILE "

do_configure_prepend() {
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
	sed -i -e "s|CPU_ARCH =|CPU_ARCH = ${TARGET_ARCH}|" \
	       -e  s:'$(OS_TEST)':${TARGET_ARCH}:g \
	           ${S}/security/coreconf/Linux.mk
}


do_stage() {
	:
}	


FILES_${PN} += "${libdir}/fennec" 

