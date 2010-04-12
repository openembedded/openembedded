DESCRIPTION = "C++ library for SOAP, the Simple Object Access Protocol"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://activecampus2.ucsd.edu/apt/sarge/easysoap++/easysoap++_${PV}.orig.tar.gz;name=archive \
  http://activecampus2.ucsd.edu/apt/sarge/easysoap++/easysoap++_${PV}-5.diff.gz;patch=1;name=patch \
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

SRC_URI[archive.md5sum] = "b87c02bf22b6697bce9df32be40d018f"
SRC_URI[archive.sha256sum] = "eac200dacbde374a7c8b3830a665b9926eb82f695f593b54a3256b29e39df29e"
SRC_URI[patch.md5sum] = "fecfbc5272922f85635d0229d1b05260"
SRC_URI[patch.sha256sum] = "37e5aab00a316a22329c64848f467b0ce73bba3bcb08c4cba6d193ba8f5e9b90"
