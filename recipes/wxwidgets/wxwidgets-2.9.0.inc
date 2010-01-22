require wxwidgets.inc

INC_PR = "r0"

PROVIDES += "wxwidgets"

TOOLKIT ?= "gtk2"
UNICODE ?= "${@base_contains('EXTRA_OECONF', '--disable-unicode', 'ansi', 'unicode', d)}"
DEBUG ?= "${@base_contains('EXTRA_OECONF', '--enable-debug', 'debug', 'release', d)}"
RELEASE ?= "${@bb.data.getVar('PV',d,1).rsplit('.', 1)[0]}"

WXCONFIG ?= "${TOOLKIT}-${UNICODE}-${DEBUG}-${RELEASE}"

LEAD_SONAME = "libwx_.*_core-.*\.so"

# Patch and regenerate configure script so that it finds staging root.
FILESDIR = "${FILE_DIRNAME}/wxwidgets-${PV}"
SRC_URI += "file://configure-cross_root.patch;patch=1"

do_configure_prepend() {
	./autogen.sh
}

do_stage() {
	install -d ${STAGING_INCDIR}/wx-${RELEASE}/wx
	cp -pR include/wx ${STAGING_INCDIR}/wx-${RELEASE}
	cp -pR lib/libwx* ${STAGING_LIBDIR}
	cp -pR lib/wx     ${STAGING_LIBDIR}
	cp -pR build/bakefiles/wxpresets/presets ${STAGING_DATADIR}/bakefile
	cp -p wxwin.m4                          ${STAGING_DATADIR}/aclocal
	ln -sf ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}${WXCONFIG} \
		${STAGING_BINDIR_CROSS}/wx-config
	sed -e s,'wxconfdir=".*"','wxconfigdir="${STAGING_LIBDIR}/wx/config"', \
		-e s,'bindir=".*"','bindir="${STAGING_BINDIR}"', \
		-e s,'libdir=".*"','libdir="${STAGING_LIBDIR}"', \
		-e s,'includedir=".*"','includedir="${STAGING_INCDIR}"', \
		-i ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}${WXCONFIG}
}

do_install() {
	oe_runmake 'DESTDIR=${D}' install
	ln -sf  ${libdir}/wx/config/${TARGET_PREFIX}${WXCONFIG} \
		${D}${bindir}/wx-config
}
