DESCRIPTION = "WBXML parsing and encoding library"
LICENSE = "LGPL"

DEPENDS = "expat popt"

SRC_URI = "${SOURCEFORGE_MIRROR}/wbxmllib/${PN}-${PV}.tar.gz \
	   file://00-fix-includes.patch;patch=1 \
	   file://01-anonymous-support-and-misc-fixes.patch;patch=1 \
	   file://02-namespaces.patch;patch=1 \
	   file://04_saxlike_entity_parsing.patch;patch=1 \
	   file://05-syncml-fixes.patch;patch=1 \
	   file://06-no-install-docs.patch;patch=1 \
	   file://07-current_attr_null.patch;patch=1 \
	   file://08-maxsize-translation-table.patch;patch=1;pnum=0 \
	   "

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

PACKAGES += "${PN}-tools"

FILES_${PN}-tools = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"



