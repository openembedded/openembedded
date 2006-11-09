DESCRIPTION = "Basic packages required for a pivot root image"
PR = "r0"

# The PIVOTBOOT_EXTRA_ variables are often manipulated by the
# MACHINE .conf files, so adjust PACKAGE_ARCH accordingly.
PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY = 1
PACKAGES = "${PN}"

MODUTILS ?= "24 26"

require task-bootstrap.inc

HOTPLUG ?= "linux-hotplug"

RDEPENDS = 'base-files base-passwd busybox \
	netbase modutils-initscripts \
	${HOTPLUG} \
	${PIVOTBOOT_EXTRA_RDEPENDS} \
	${@bootstrap_modutils_rdepends(d)}'

RRECOMMENDS = '${PIVOTBOOT_EXTRA_RRECOMMENDS}'
LICENSE = MIT
