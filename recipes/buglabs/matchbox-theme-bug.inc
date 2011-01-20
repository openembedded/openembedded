LICENSE = "CC-BY-SA3"
DEPENDS = "matchbox-wm"
SECTION = "x11/wm"

SRCREV = "12121"

SRC_URI += "svn://bugcamp.net/bug/trunk/;module=com.buglabs.bug.theme/matchbox/${THEME_NAME} \
            file://session"

FILES_${PN} = "${datadir}/themes/${THEME_NAME} \
               ${sysconfdir}/matchbox/session"

S = ${WORKDIR}/com.buglabs.bug.theme/matchbox/${THEME_NAME}

REQUIRES = "matchbox-sato"

do_install() {
    install -m 0755 -d ${D}${datadir}/themes/${THEME_NAME}/matchbox
    install -m 0755 -d ${D}${datadir}/themes/${THEME_NAME}/gtk-2.0

    install -m 0644 ${S}/index.theme ${D}${datadir}/themes/${THEME_NAME}/
    install -m 0644 ${S}/gtk-2.0/*.png ${D}${datadir}/themes/${THEME_NAME}/gtk-2.0/
    install -m 0644 ${S}/gtk-2.0/gtkrc ${D}${datadir}/themes/${THEME_NAME}/gtk-2.0/
    install -m 0644 ${S}/matchbox/*.png ${D}${datadir}/themes/${THEME_NAME}/matchbox/
    install -m 0644 ${S}/matchbox/theme.xml ${D}${datadir}/themes/${THEME_NAME}/matchbox/
    install -m 0755 -d ${D}${sysconfdir}/matchbox
    install -m 0744 ${WORKDIR}/session ${D}${sysconfdir}/matchbox/session
}

pkg_postinst_${PN} () {
	if [ "x$D" != "x" ]; then
		exit 1
	fi

	. ${sysconfdir}/init.d/functions

	gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/theme ${THEME_NAME}
	gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/icon_theme Bug
	gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type bool --set /desktop/poky/interface/touchscreen true
	gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/font_name "Sans 9"
}

