DESCRIPTION = "Core packages required for a basic installation with unionroot"
PROVIDES = "task-bootstrap"
RPROVIDES = "task-bootstrap"
PR = "r2"
DEFAULT_PREFERENCE = "-1"

# The BOOTSTRAP_EXTRA_ variables are often manipulated by the
# MACHINE .conf files, so adjust PACKAGE_ARCH accordingly.
PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY = "1"

MODUTILS ?= "24 26"

require task-bootstrap.inc

HOTPLUG ?= "linux-hotplug"

RDEPENDS = 'base-files base-passwd busybox \
	initscripts \
	netbase sysvinit sysvinit-pidof tinylogin \
	modutils-initscripts \
	${HOTPLUG} \
	${BOOTSTRAP_EXTRA_RDEPENDS} \
	${@bootstrap_modutils_rdepends(d)} \
	unionfs-modules \
	unionfs-utils \
	unionroot \
	unionroot-utils'

RRECOMMENDS = 'dropbear portmap \
	${BOOTSTRAP_EXTRA_RRECOMMENDS}'
LICENSE = "MIT"
