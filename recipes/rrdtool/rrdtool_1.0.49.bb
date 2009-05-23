DESCRIPTION = "High performance data logging and graphing system for time series data."
HOMEPAGE = "http://oss.oetiker.ch/rrdtool/"
SECTION = "utils"
LICENSE = "GPLv2"
DEPENDS = "libpng zlib"
DEPENDS_rddtool-perl = "perl-module-lib perl-module-dynaloader"
PR = "r2"
SRC_URI = "http://oss.oetiker.ch/rrdtool/pub/rrdtool-1.0.x/rrdtool-${PV}.tar.gz \
	file://perl-make-options.diff;patch=1;pnum=0"

inherit autotools

EXTRA_OECONF = "--enable-shared --enable-local-libpng --enable-local-zlib --program-prefix=''"

do_configure_append_nylon() {
  perl -pi -e 's/-Wdeclaration-after-statement //g' ${S}/perl-shared/Makefile
}

do_install_append() {
	install -d ${D}${docdir}/rrdtool/
	mv ${D}/usr/html ${D}${docdir}/rrdtool/
	mv ${D}/usr/doc/* ${D}${docdir}/rrdtool/
	mv ${D}/usr/examples ${D}${docdir}/rrdtool/
	mv ${D}/usr/contrib ${D}${docdir}/rrdtool/
}

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/perl/auto/RRDs/RRDs.bs ${libdir}/perl/auto/RRDs/RRDs.so ${libdir}/perl/RRDs.pm ${libdir}/perl/RRDp.pm"

