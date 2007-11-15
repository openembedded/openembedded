DESCRIPTION = "A library for object-oriented inter process communication"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "unknown"
DEPENDS="zlib openssl boost-asio"

# the SOURCE_URI requires authentication via web browser and cookie (gasp)
# all we can do right now is download the file and save it under sources/
SRC_URI = "http://www.mediaassistent.se/jarl/files/RCF-04.zip \
	file://rcf-0.4-g++-4.1.diff;patch=1 \
	file://rcf-0.4-openembedded.diff;patch=1"
S = "${WORKDIR}/RCF-${PV}"

CPPFLAGS_prepend = "-I../../include "
BUILD_OPTIMIZATION = "-Os"

do_compile() {
	oe_runmake CXXFLAGS="-pthread ${CXXFLAGS}" -C src/RCF shared-mt
	oe_runmake -C src/RCF shared-st
	rm -f src/RCF/*.o
	oe_runmake CXXFLAGS="-pthread ${CXXFLAGS}" -C src/RCF mt
	oe_runmake -C src/RCF st
}

do_install() {
	oe_runmake -C src/RCF prefix=/usr DESTDIR=${D} install
	find ${D}/usr/include -name "*.diff" | xargs rm
}

do_stage() {
	cd ${S}
	install -d -m 775 ${STAGING_LIBDIR}
	cp -dp src/RCF/libRCF[sm]t.a ${STAGING_LIBDIR}
	cp -dp src/RCF/libRCF[sm]t.so* ${STAGING_LIBDIR}
	install -d -m 775 ${STAGING_INCDIR}
	tar -C include --exclude='*.diff' -cvf - . | tar -C ${STAGING_INCDIR} -xvf -
}

PACKAGES = "${PN}-mt ${PN}-st ${PN}-dev"
FILES_${PN}-mt = "/usr/lib/libRCFmt.so*"
FILES_${PN}-st = "/usr/lib/libRCFst.so*"
FILES_${PN}-dev = "/usr/lib/libRCF[sm]t.a /usr/include"
