inherit gpe

DESCRIPTION = "GPE session startup scripts"
LICENSE = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
RDEPENDS_${PN} = "matchbox-panel (>= 0.9.2-r12) matchbox-desktop (>= 0.9.1-r1) matchbox-common (>= 0.9.1-r2) gpe-session-starter gpe-bluetooth xstroke xtscal gpe-question gpe-clock matchbox-applet-inputmanager xrandr xmodmap xdpyinfo xserver-common"
# more rdepends: keylaunch ipaq-sleep apmd blueprobe
DEPENDS = "matchbox-wm matchbox-panel gpe-bluetooth xstroke xtscal gpe-question matchbox-applet-inputmanager gpe-clock xrandr xmodmap xdpyinfo xserver-common"

SRC_URI += "file://matchbox-session \
	file://disable-composite.xsettings"

PR = "r4"

#apply a patch to set the fontsize for bigdpi (200+) devices to 5
SRC_URI_append_hx4700 = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_spitz = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_akita = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_c7x0 = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_nokia770 = " file://highdpifontfix.patch;patch=1"


do_configure_append_angstrom() {
	sed -i s:Default:Clearlooks:g X11/xsettings.default
	sed -i s:Industrial:Clearlooks:g X11/xsettings.default
}	

do_install_append() {
	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	if [ "${GUI_MACHINE_CLASS}" != "bigscreen" ]; then
		echo "Gtk/ToolbarStyle:S:icons" > ${D}${sysconfdir}/gpe/xsettings-default.d/toolbar
	fi
	install -d ${D}${sysconfdir}/matchbox
	install ${WORKDIR}/matchbox-session ${D}${sysconfdir}/matchbox/session

	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	install -m 0644 ${WORKDIR}/disable-composite.xsettings ${D}${sysconfdir}/gpe/xsettings-default.d/disable-composite
	
	mv ${D}/usr/bin/gpe-logout ${D}/usr/bin/gpe-logout.matchbox
}

pkg_postinst_${PN}() { 
	update-alternatives --install /usr/bin/gpe-logout gpe-logout /usr/bin/gpe-logout.matchbox 10
}

pkg_postrm_${PN}() {   
       update-alternatives --remove gpe-logout /usr/bin/gpe-logout.matchbox 
}

# This makes use of GUI_MACHINE_CLASS, so set PACKAGE_ARCH appropriately
PACKAGE_ARCH = "${MACHINE_ARCH}"
