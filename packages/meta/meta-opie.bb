DESCRIPTION = "Meta-package for Opie"
SECTION = "opie/base"
ALLOW_EMPTY = 1
PR = "r34"
PACKAGE_ARCH = "all"
LICENSE = "MIT"
BUILD_ALL_DEPS=1

DEPENDS = "task-opie"
RDEPENDS = "task-opie-applets task-opie-apps task-opie-base \
            task-opie-base-applets task-opie-base-apps \
            task-opie-base-decorations task-opie-base-inputmethods \
            task-opie-base-pim task-opie-base-settings \
            task-opie-base-styles task-opie-bluetooth \
            task-opie-datebookplugins task-opie-decorations \
            task-opie-extra-apps task-opie-extra-settings \
            task-opie-extra-styles task-opie-extra-games \
            task-opie-games task-opie-inputmethods task-opie-irda \
            task-opie-multimedia task-opie-pim task-opie-settings \
            task-opie-styles task-opie-todayplugins task-opie-wlan"

