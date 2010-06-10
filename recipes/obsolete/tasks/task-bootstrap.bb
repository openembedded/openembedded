DESCRIPTION = "Core packages required for a basic installation"
PR = "r26"

# The BOOTSTRAP_EXTRA_ variables are often manipulated by the
# MACHINE .conf files, so adjust PACKAGE_ARCH accordingly.
PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY = "1"

MODUTILS ?= "24 26"

require task-bootstrap.inc

HOTPLUG ?= "linux-hotplug"

RDEPENDS_${PN} = 'base-files base-passwd busybox \
	initscripts \
	netbase sysvinit sysvinit-pidof tinylogin \
	modutils-initscripts fuser setserial\
	${HOTPLUG} \
	${BOOTSTRAP_EXTRA_RDEPENDS} \
	${@bootstrap_modutils_rdepends(d)}'

RRECOMMENDS_${PN} = 'dropbear portmap \
	${BOOTSTRAP_EXTRA_RRECOMMENDS}'
LICENSE = "MIT"
