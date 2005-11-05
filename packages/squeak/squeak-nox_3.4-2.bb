DESCRIPTION = "Squeak VM for QtEmbedded"
SECTION = "devel"
PRIORITY = "optional"
MAINTAINER = "Torsten Sadowski <tsadowski@gmx.net>"
LICENSE = "Squeak License"
HOMEPAGE = "http://www.squeak.org"
DEPENDS = "virtual/libqpe"
PROVIDES = "virtual/squeak-nox"
PR = "r1"

SRC_URI = "http://keepcool.kf.tu-berlin.de/public/mitarbeiter/sadowski/qtopia-squeak-${PV}_patched.tar.gz \
           file://Makefile.in"
S = "${WORKDIR}"

EXTRA_OECONF = ' --host=arm-linux --without-x --without-npsqueak --with-audio=oss'

inherit palmtop

do_configure() {
	cp platforms/unix/vm/aio.h platforms/unix/vm/sqaio.h
	cp ${WORKDIR}/Makefile.in platforms/unix/vm/Makefile.in
	rm -rf build
	mkdir build
	cd build
	../platforms/unix/config/configure ${EXTRA_OECONF}
}

do_compile() {
	cd build
	make
}

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 ${WORKDIR}/build/squeak-nox ${D}${palmtopdir}/bin/
	install -d ${D}/${palmtopdir}/apps/Applications/
	install -m 0644 squeak.desktop ${D}/${palmtopdir}/apps/Applications/squeak.desktop
	install -d ${D}/${palmtopdir}/pics/
	install -m 0644 SqueakLogo.png ${D}/${palmtopdir}/pics/SqueakLogo.png
	install -d ${D}/${palmtopdir}/share/apps/squeak/
	install -m 0644 README ${D}/${palmtopdir}/share/apps/squeak/
}
