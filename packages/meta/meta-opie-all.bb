DESCRIPTION = "Meta-package for QPE stuff"
SECTION = "opie/base"
ALLOW_EMPTY = 1
PACKAGE_ARCH = "all"
LICENSE = "MIT"
DEPENDS = "task-qpe"
PR = "r3"

BUILD_ALL_DEPS = 1

RDEPENDS = "task-qpe-applets task-qpe-games task-qpe-inputmethods \
	task-qpe-multimedia task-qpe-emulators task-qpe-applications \
	task-qpe-fonts task-qpe-settings"

