SECTION = "base"
PRIORITY = "optional"
DEPENDS = ""
DESCRIPTION = "Event driven system init"
LICENSE = "GPL"

inherit autotools pkgconfig 

# --enable-compat builds halt, reboot, shutdown tools
EXTRA_OECONF += "--enable-compat"

do_stage () {
 	autotools_stage_all
}

# libupstart can be used for upstart event generation from other programs.
# However it is not used by upstart itself, so package it seperately.
PACKAGES =+ "libupstart libupstart-dev"
FILES_libupstart += "${libdir}/libupstart.so.*"
FILES_libupstart-dev += "${libdir}/libupstart.* ${includedir}/upstart/"

# upstart-sysvcompat provides Sys V Init compatible tools: halt, reboot,
# shutdown, telinit. These might be needed by other scripts.
PACKAGES =+ "upstart-sysvcompat upstart-sysvtools-doc"
FILES_upstart-sysvcompat += "${sbindir}/reboot ${sbindir}/halt ${sbindir}/shutdown ${sbindir}/telinit"
FILES_upstart-sysvcompat-doc += "${mandir}/*/reboot.* ${mandir}/*/halt.* ${mandir}/*/shutdown.* ${mandir}/*/telinit.*"
