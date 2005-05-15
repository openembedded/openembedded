DESCRIPTION = "Ecore is the core event abstraction layer for the \
enlightenment foundation libraries. It makes makes doing selections, drag \
and drop, event loops, timeouts and idle handlers fast, optimized, and \
convenient."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "eet evas diet-x11 xserver-kdrive"
PR = "1"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

SRC_URI = "cvs://anonymous@cvs.sourceforge.net:/cvsroot/enlightenment;module=ecore"
S = "${WORKDIR}/ecore"

inherit autotools binconfig

export EET_CONFIG = "${STAGING_BINDIR}/eet-config"
export EVAS_CONFIG = "${STAGING_BINDIR}/evas-config"

EXTRA_OECONF = "--enable-ecore-fb \
		--enable-ecore-job \
                --enable-ecore-evas \
		--enable-ecore-evas-fb \
		--enable-ecore-evas-x \
		--disable-ecore-evas-gl \
		--enable-ecore-con \
		--enable-ecore-ipc \
		--enable-ecore-txt \
		--enable-ecore-x \
		--enable-ecore-config \
		--disable-openssl"

parts = "Ecore Ecore_Job \
	 Ecore_Txt Ecore_Fb Ecore_Con \
	 Ecore_Ipc Ecore_Evas Ecore_Config \
         Ecore_X"

do_stage () {
  for p in ${parts}; do
    dir=`echo $p|tr A-Z a-z`
    install -m 0644 ${S}/src/lib/$dir/$p.h ${STAGING_INCDIR}/
    oe_libinstall -C src/lib/$dir lib$dir ${STAGING_LIBDIR}/
  done
  install -m 0644 ${S}/src/lib/ecore/Ecore_Data.h ${STAGING_INCDIR}/
  install -m 0644 ${S}/ecore.m4 ${STAGING_DATADIR}/aclocal/
}

PACKAGES += "ecore-examples"

FILES_${PN} = "${libdir}/libecore*.so* ${libdir}/ecore_config_ipc_ecore.so"
FILES_${PN}-dev += "${bindir}/ecore-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/ecore_test ${bindir}/ecore_evas_test ${datadir}"
