inherit gpe

DESCRIPTION = "GPE session startup scripts hack for GPE Phone Edition"
LICENSE = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
RDEPENDS_${PN} = "gpe-applauncher gpe-phonepanel gpe-session-starter gpe-question xmodmap xdpyinfo xserver-common esd esd-utils"
DEPENDS = "matchbox-wm gpe-applauncher gpe-phonepanel gpe-question xmodmap xdpyinfo xserver-common esound"

SRC_URI = "${GPE_MIRROR}/gpe-session-scripts-${PV}.tar.gz \
           file://matchbox-session \
           file://matchbox-session.vm \
           file://phonesession \
	   file://disable-composite.xsettings \
           file://standard-apps.patch;patch=1"

PR = "r10"

S = "${WORKDIR}/gpe-session-scripts-${PV}"


# We assume that x86 means we are building an emulation image
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

	install -d ${D}${sysconfdir}/X11
	install -m 755 ${WORKDIR}/phonesession ${D}${sysconfdir}/X11/phonesession
}

do_install_append_x86() {
	install ${WORKDIR}/matchbox-session.vm ${D}${sysconfdir}/matchbox/session
}

pkg_postinst_${PN}() {
	update-alternatives --install /usr/bin/gpe-logout gpe-logout /usr/bin/gpe-logout.matchbox 10
}

pkg_postrm_${PN}() {
       update-alternatives --remove gpe-logout /usr/bin/gpe-logout.matchbox
}

# This makes use of GUI_MACHINE_CLASS, so set PACKAGE_ARCH appropriately
PACKAGE_ARCH = "${MACHINE_ARCH}"
