DESCRIPTION = "This collection of code replaces the existing linux-hotplug \
package with very tiny, compiled executable programs, instead of the \
existing bash scripts."
LICENSE = "GPL"
RPROVIDES_${PN} = "hotplug"
RCONFLICTS_${PN} = "hotplug"
RREPLACES_${PN} = "hotplug"

SRC_URI = "svn://svn.schwerkraft.elitedvb.net/svnroot;module=hotplug-ng"
SRCDATE = "20080527"
PV = "2.0cvs${SRCDATE}"

S = "${WORKDIR}/hotplug-ng/trunk"

LD = "${CC}"
export HOSTCC = "${BUILD_CC}"
CFLAGS = " -I${S}/libsysfs/sysfs"
# Stripping should be done when _packaging_, not building
EXTRA_OEMAKE += "'STRIP=/bin/true'"

export etcdir = "${sysconfdir}"
export sbindir = "${base_sbindir}"
export bindir = "${base_bindir}"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
