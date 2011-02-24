LICENSE = "GPL LGPL"
DEPENDS = "libxml2 libxslt libxslt-native libxml2-native gettext-native"
DEPENDS_virtclass-native = "libxslt-native libxml2-native gettext-native"

INC_PR = "r6"

inherit gnomebase

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend() {
	sed -i -e 's: doc::g' ${S}/Makefile.am
}

do_install_append() {
	mkdir -p  ${D}${datadir}/xml/gnome/xslt/
	cp -pPr ${S}/xslt/* ${D}${datadir}/xml/gnome/xslt/
	sed -i "1s:.*:#!/usr/bin/env python:" ${D}${bindir}/xml2po
}

FILES_${PN} += "${datadir}/xml*"

BBCLASSEXTEND = "native"

