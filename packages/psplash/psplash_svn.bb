DESCRIPTION = "Userspace framebuffer boot logo based on usplash."
HOMEPAGE = "http://projects.o-hand.com/psplash"
SECTION = "base"
LICENSE = "GPL"
PV = "0.0+svnr${SRCREV}"
PR = "r13"
RDEPENDS = "initscripts"

# You can create your own pslash-hand-img.h by doing
# ./make-image-header.sh <file>.png HAND
# and rename the resulting .h to pslash-hand-img.h (for the logo)
# respectively psplash-bar-img.h (BAR) for the bar.
# You might also want to patch the colors (see patch)

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=psplash;proto=http \
          file://psplash-hand-img.h \
          file://psplash-bar-img.h \
          file://psplash-init"
S = "${WORKDIR}/psplash"

# This really should be default, but due yo openmoko hack below, can't be easily
SRC_URI_append_angstrom = " file://logo-math.patch;patch=1 "
SRC_URI_append_openmoko = " file://configurability.patch;patch=1 "

inherit autotools pkgconfig update-rc.d

do_configure_append() {
	install -m 0644 ${WORKDIR}/psplash-hand-img.h ${S}/
	install -m 0644 ${WORKDIR}/psplash-bar-img.h ${S}/
}

do_install_prepend() {
	install -d ${D}/mnt/.psplash/
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/psplash-init ${D}${sysconfdir}/init.d/psplash
}

INITSCRIPT_NAME = "psplash"
INITSCRIPT_PARAMS = "start 01 S . stop 20 0 1 6 ."

FILES_${PN} += "/mnt/.psplash"
