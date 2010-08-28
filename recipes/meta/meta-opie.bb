DESCRIPTION = "Meta-package for Opie"
SECTION = "opie/base"
PR = "r35"
LICENSE = "MIT"

RDEPENDS_${PN} = "task-opie-applets task-opie-apps task-opie-base \
            task-opie-base-applets task-opie-base-apps \
            task-opie-base-decorations task-opie-base-inputmethods \
            task-opie-base-pim task-opie-base-settings \
            task-opie-base-styles \
            ${@base_contains("COMBINED_FEATURES", "bluetooth", "task-opie-bluetooth", "",d)} \
            task-opie-datebookplugins task-opie-decorations \
            task-opie-extra-apps task-opie-extra-settings \
            task-opie-extra-styles task-opie-extra-games \
            ${@base_contains("COMBINED_FEATURES", "irda", "task-opie-irda", "",d)} \
            task-opie-games task-opie-inputmethods \
            task-opie-multimedia task-opie-pim task-opie-settings \
            task-opie-styles task-opie-todayplugins task-opie-wlan"

inherit meta
