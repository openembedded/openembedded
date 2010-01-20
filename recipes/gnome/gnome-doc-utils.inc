LICENSE = "GPL LGPL"
DEPENDS = "libxml2 libxslt libxslt-native"

INC_PR = "r3"

inherit gnome

EXTRA_OECONF = "--disable-scrollkeeper ac_cv_path_PYTHON=${bindir}/python"

do_install_append() {
	mkdir -p  ${D}${datadir}/xml/gnome/xslt/
	cp -pPr ${S}/xslt/* ${D}${datadir}/xml/gnome/xslt/
}

FILES_${PN} += "${datadir}/xml*"
