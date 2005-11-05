LICENSE = "GPL"
PR = "r6"

inherit gpe

DESCRIPTION = "GPE session startup scripts"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
RDEPENDS = "matchbox gpe-session-starter gpe-bluetooth xstroke xtscal gpe-question gpe-clock matchbox-applet-inputmanager xrandr"
# more rdepends: keylaunch ipaq-sleep apmd blueprobe
DEPENDS = "matchbox-wm matchbox-panel gpe-bluetooth xstroke xtscal gpe-question matchbox-applet-inputmanager gpe-clock xrandr"

SRC_URI += "file://change-default-applets.patch;patch=1"

do_install_append() {
	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	if [ "${GUI_MACHINE_CLASS}" != "bigscreen" ]; then
		echo "Gtk/ToolbarStyle:S:icons" > ${D}${sysconfdir}/gpe/xsettings-default.d/toolbar
	fi
}

# This makes use of GUI_MACHINE_CLASS, so set PACKAGE_ARCH appropriately
PACKAGE_ARCH = "${MACHINE_ARCH}"
