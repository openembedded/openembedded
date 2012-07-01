DESCRIPTION = "Userspace framebuffer boot logo based on usplash."
HOMEPAGE = "http://git.yoctoproject.org/cgit/cgit.cgi/psplash"
SECTION = "base"
LICENSE = "GPLv2+"
PROVIDES = "virtual/psplash"
RPROVIDES_${PN} = "virtual-psplash"
RCONFLICTS_${PN} = "exquisite"

SRCREV = "d8ebee6f2b14d72b69bd37f1ea7e64e936a24695"
PV = "0.1+git${SRCPV}"
PR = "r0"

# You can create your own pslash-poky-img.h by doing
# ./make-image-header.sh <file>.png POKY
# and rename the resulting .h to pslash-poky-img.h (for the logo)
# respectively psplash-bar-img.h (BAR) for the bar.
# You might also want to patch the colors (see patch)

inherit autotools pkgconfig update-rc.d

do_configure_append() {
	install -m 0644 ${WORKDIR}/psplash-poky-img.h ${S}/
	install -m 0644 ${WORKDIR}/psplash-bar-img.h ${S}/

	if [ -e "${WORKDIR}/psplash.h" ]; then
		install -m 0644 ${WORKDIR}/psplash.h ${S}/
	fi
}

do_install_prepend() {
	install -d ${D}/mnt/.splash/
	install -d ${D}${sysconfdir}/default/
	install -m 0644 ${WORKDIR}/psplash-default ${D}${sysconfdir}/default/psplash
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/psplash-init ${D}${sysconfdir}/init.d/psplash
	install -d ${D}${bindir}
	ln -s psplash-write ${D}${bindir}/splash-write
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/splashfuncs ${D}${sysconfdir}/default/splashfuncs
}

INITSCRIPT_NAME = "psplash"
INITSCRIPT_PARAMS = "start 01 S . stop 20 0 1 6 ."

PACKAGES =+ "psplash-support"

RDEPENDS_${PN} += "psplash-support"
FILES_psplash-support += "/mnt/.splash ${sysconfdir} ${bindir}/psplash-write ${bindir}/splash-write"
