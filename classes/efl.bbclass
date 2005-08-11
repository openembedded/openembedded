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

def binconfig_suffix(d):
	import bb
        return ["","-native"][bb.data.inherits_class('native', d)]

export CURL_CONFIG		= "${STAGING_BINDIR}/curl-config${@binconfig_suffix(d)}"
export EDB_CONFIG		= "${STAGING_BINDIR}/edb-config${@binconfig_suffix(d)}"
export EET_CONFIG		= "${STAGING_BINDIR}/eet-config${@binconfig_suffix(d)}"
export EVAS_CONFIG		= "${STAGING_BINDIR}/evas-config${@binconfig_suffix(d)}"
export ECORE_CONFIG		= "${STAGING_BINDIR}/ecore-config${@binconfig_suffix(d)}"
export EMBRYO_CONFIG		= "${STAGING_BINDIR}/embryo-config${@binconfig_suffix(d)}"
export ENGRAVE_CONFIG		= "${STAGING_BINDIR}/engrave-config${@binconfig_suffix(d)}"
export ENLIGHTENMENT_CONFIG	= "${STAGING_BINDIR}/enlightenment-config${@binconfig_suffix(d)}"
export EPSILON_CONFIG		= "${STAGING_BINDIR}/epsilon-config${@binconfig_suffix(d)}"
export EPEG_CONFIG		= "${STAGING_BINDIR}/epeg-config${@binconfig_suffix(d)}"
export ESMART_CONFIG		= "${STAGING_BINDIR}/esmart-config${@binconfig_suffix(d)}"
export FREETYPE_CONFIG		= "${STAGING_BINDIR}/freetype-config${@binconfig_suffix(d)}"
export IMLIB2_CONFIG		= "${STAGING_BINDIR}/imlib2-config${@binconfig_suffix(d)}"

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

PACKAGES = "${SRCNAME}-dev ${SRCNAME}-examples ${SRCNAME} ${SRCNAME}-theme"
FILES_${SRCNAME} = "${libdir}"
FILES_${SRCNAME}-theme = "${datadir}/${SRCNAME}/themes"
FILES_${SRCNAME}-dev += "${bindir}/${SRCNAME}-config ${libdir}/pkgconfig"
FILES_${SRCNAME}-examples = "${bindir} ${datadir}"

