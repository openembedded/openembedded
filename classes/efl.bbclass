MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"

SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-native', '')}"
SRC_URI = "http://enlightenment.freedesktop.org/files/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit autotools pkgconfig binconfig

INHIBIT_AUTO_STAGE_INCLUDES  = "1"
INHIBIT_NATIVE_STAGE_INSTALL = "1"

libdirectory = "src/lib"
libraries = "lib${SRCNAME}"
headers = "${@bb.data.getVar('SRCNAME',d,1).capitalize()}.h"

do_stage_append () {
	for i in ${libraries}
	do
		oe_libinstall -C ${libdirectory} $i ${STAGING_LIBDIR}
	done
	for i in ${headers}
	do
		install -m 0644 ${libdirectory}/$i ${STAGING_INCDIR}
	done
}

PACKAGES = "${SRCNAME}-dev ${SRCNAME}-examples ${SRCNAME}"
FILES_${SRCNAME} = "${libdir}"
FILES_${SRCNAME}-dev += "${bindir}/${SRCNAME}-config ${libdir}/pkgconfig"
FILES_${SRCNAME}-examples = "${bindir} ${datadir}"

