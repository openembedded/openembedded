LICENSE = "GPL/LGPL"
DEPENDS = "libxml2 libxslt"

PR = "r1"

inherit gnome

FILES_${PN} += "${datadir}/xml*"

do_stage() {
	mkdir -p  ${STAGING_DATADIR}/xml/gnome/xslt/
	cp -pPr ${S}/xslt/* ${STAGING_DATADIR}/xml/gnome/xslt/
	autotools_stage_all
}
