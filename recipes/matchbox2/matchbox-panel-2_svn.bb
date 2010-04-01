DESCRIPTION = "matchbox-panel-2 is a lightweight dock (system tray) application based on Gtk+"
LICENSE = "GPLv2"
SECTION = "x11/panels"
DEPENDS = "gtk+ startup-notification dbus dbus-glib matchbox-panel-2-icon-themes"
DEPENDS += " ${@base_contains("MACHINE_FEATURES", "acpi", "libacpi", "",d)}"
DEPENDS += " ${@base_contains("MACHINE_FEATURES", "apm", "apmd", "",d)}"
RDEPENDS_${PN} = "matchbox-panel-2-icon-theme"
PACKAGE_ARCH = "${MACHINE_ARCH}"
SRCREV = "2098"
PV = "2.0+svnr${SRCPV}"
PR = "r1"

inherit autotools_stage pkgconfig

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http \
	   file://scaling-image-double-free.patch;patch=1;pnum=0 \
	   file://startup-invalid-access.patch;patch=1;pnum=0 \
	   file://startup-shown-uninitialized.patch;patch=1;pnum=0 \
	   file://themeable-icons.patch;patch=1;pnum=0 \
"
S = "${WORKDIR}/${PN}"

TARGET_CFLAGS += "-Wno-error"

EXTRA_OECONF = "--disable-static --program-transform-name='s/$/-2/'"
EXTRA_OECONF += " ${@base_contains("MACHINE_FEATURES", "acpi", "--with-battery=acpi", "",d)}"
EXTRA_OECONF += " ${@base_contains("MACHINE_FEATURES", "apm", "--with-battery=apm", "",d)}"

do_install_append() {
	rm ${D}${libdir}/matchbox-panel/lib*.*a
}

FILES_${PN} += "${libdir}/matchbox-panel/*.so"
FILES_${PN}-dbg += "${libdir}/matchbox-panel/.debug"
