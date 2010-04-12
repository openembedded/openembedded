DESCRIPTION = "This collection of code replaces the existing linux-hotplug \
package with very tiny, compiled executable programs, instead of the \
existing bash scripts."
LICENSE = "GPL"
RPROVIDES_${PN} = "hotplug"
RCONFLICTS_${PN} = "hotplug"
RREPLACES_${PN} = "hotplug"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/hotplug/hotplug-ng-${PV}.tar.gz"

#S = "${WORKDIR}/hotplug-ng-${PV}"

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

SRC_URI[md5sum] = "faa08f321fefd2c61ce4c9355a62fe31"
SRC_URI[sha256sum] = "ca7ef124cde06883fbf28c7e78ce1e4c5526434bbe5672ef0a3e85a61a9d0b5f"
