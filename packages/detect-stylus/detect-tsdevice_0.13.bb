inherit gpe

DESCRIPTION = "Touchscreen device detection utility"
LICENSE = "GPL"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "base"

SRC_URI = "${GPE_MIRROR}/detect-stylus-${PV}.tar.gz \
           file://access.patch;patch=1;pnum=0 \
           file://extra-device-check.patch;patch=1 \
           file://correct-theme-name.patch;patch=1 \
           file://nox.patch;patch=1"
S = "${WORKDIR}/detect-stylus-${PV}"

export CVSBUILD = "no"
export NOX = "yes"

do_install_append () {
	mv ${D}${bindir}/detect-stylus ${D}${bindir}/detect-tsdevice
}
