DESCRIPTION = "Basic packages required for a pivot root image"
MAINTAINER = "Jonathan McDowell <noodles@earth.li>"
PR = "r0"

# The PIVOTBOOT_EXTRA_ variables are often manipulated by the
# MACHINE .conf files, so adjust PACKAGE_ARCH accordingly.
PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

MODUTILS ?= "24 26"

def bootstrap_modutils_rdepends(d):
	import bb
        m = bb.data.getVar('MODUTILS', d, 1)
        r = []
	if '24' in m:
                r.append('modutils-depmod')
        if '26' in m:
                r.append('module-init-tools-depmod')
        return ' '.join(r)

HOTPLUG ?= "linux-hotplug"

RDEPENDS = 'base-files base-passwd busybox \
	netbase modutils-initscripts \
	${HOTPLUG} \
	${PIVOTBOOT_EXTRA_RDEPENDS} \
	${@bootstrap_modutils_rdepends(d)}'

RRECOMMENDS = '${PIVOTBOOT_EXTRA_RRECOMMENDS}'
LICENSE = MIT
