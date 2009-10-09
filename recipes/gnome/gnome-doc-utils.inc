LICENSE = "GPL LGPL"
DEPENDS = "libxml2 libxslt libxslt-native"

INC_PR = "r2"

inherit gnome

EXTRA_OECONF = "--disable-scrollkeeper ac_cv_path_PYTHON=${bindir}/python"

do_stage() {
	mkdir -p  ${STAGING_DATADIR}/xml/gnome/xslt/
	cp -pPr ${S}/xslt/* ${STAGING_DATADIR}/xml/gnome/xslt/
	autotools_stage_all
}

FILES_${PN} += "${datadir}/xml*"
