DESCRIPTION = "C++ library for SOAP, the Simple Object Access Protocol"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://activecampus2.ucsd.edu/apt/sarge/easysoap++/easysoap++_${PV}.orig.tar.gz \
  http://activecampus2.ucsd.edu/apt/sarge/easysoap++/easysoap++_${PV}-5.diff.gz;patch=1 \
  file://libeasysoap++0-0.6.1/libeasysoap++0-0.6.1-template-keyword-qualifier-swb.patch;patch=1 \
  file://libeasysoap++0-0.6.1/libeasysoap++0-0.6.1-compile-errors-swb.patch;patch=1 \
  file://libeasysoap++0-0.6.1/libeasysoap++0-0.6.1-autoreconf-fixes-swb.patch;patch=1"

S = "${WORKDIR}/EasySoap++-${PV}"

inherit autotools

do_stage() {
	oe_libinstall -so -C src libeasysoap ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/easysoap
	for f in include/easysoap/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/easysoap
	done
}
