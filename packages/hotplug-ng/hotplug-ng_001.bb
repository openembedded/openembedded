DESCRIPTION = "This collection of code replaces the existing linux-hotplug \
package with very tiny, compiled executable programs, instead of the \
existing bash scripts."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
RPROVIDES = "hotplug"
RCONFLICTS = "hotplug"
RREPLACES = "hotplug"
PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/utils/kernel/hotplug/hotplug-ng-${PV}.tar.gz \
	   file://flags.patch;patch=1"
S = "${WORKDIR}/hotplug-ng-${PV}"

LD = "${CC}"
export HOSTCC = "${BUILD_CC}"
# Stripping should be done when _packaging_, not building
EXTRA_OEMAKE += "'STRIP=/bin/true'"

export etcdir = "${sysconfdir}"
export sbindir = "${base_sbindir}"
export bindir = "${base_bindir}"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
