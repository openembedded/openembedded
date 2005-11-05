DESCRIPTION = "Drivers and tools to support ATM networking under Linux"
HOMEPAGE = "http://linux-atm.sourceforge.net/"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Rob Taylor <rjt@cambridgebroadband.com>"
DEPENDS = "virtual/kernel"
PR = "r1"
LICENSE = "GPL LGPL"

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/linux-atm/linux-atm-${PV}.tar.gz \
           file://gcc-3.4-fix;patch=1 \
           file://qgen-cross;patch=1"
S = "${WORKDIR}/linux-atm-${PV}"

inherit autotools pkgconfig flow-lossage


headers_include="atmd.h atm.h atmsap.h"
headers_arpd="atmarp.h atmarpd.h"

binarys_sbin="maint/atmaddr maint/atmloop lane/bus ilmid/ilmid mpoad/mpcd arpd/atmarp sigd/atmsigd maint/enitune lane/lecs led/zeppelin arpd/atmarpd maint/atmtcp maint/esi lane/les maint/zntune"
binarys_bin="test/aread maint/atmdiag maint/atmdump test/awrite maint/saaldump maint/sonetdiag test/ttcp_atm"


do_compile_prepend() {
	oe_runmake -C ${S}/src/qgen AR='${BUILD_AR}' CPP='${BUILD_CPP}' CC='${BUILD_CC}' CFLAGS='${BUILD_CFLAGS}' DEFS='-I${S}/src -I. -I../.. -DHAVE_CONFIG_H' CPPFLAGS='${BUILD_CPPFLAGS}' LD='${BUILD_LD}' LDFLAGS='${BUILD_LDFLAGS}' qgen q.dump  
	oe_runmake -C ${S}/src/qgen DEFS='-I${S}/src -I. -I../.. -DHAVE_CONFIG_H' all
}

do_stage () {
	oe_libinstall -so -C src/lib libatm ${STAGING_LIBDIR}

	for i in ${headers_include}; do
		install -m 0644 src/include/$i ${STAGING_INCDIR}/$i
	done

	for i in ${headers_arpd}; do
		install -m 0644 src/arpd/$i ${STAGING_INCDIR}/$i
	done

	for i in ${binarys_sbin}; do 
		install -m 0755 src/$i ${STAGING_BINDIR}/`basename $i`
	done

	for i in ${binarys_bin}; do 
		install -m 0755 src/$i ${STAGING_BINDIR}/`basename $i`
	done
}


