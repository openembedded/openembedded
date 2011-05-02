IMAGE_LINGUAS = ""

DEPENDS = "task-base task-opie"
IMAGE_DEV_MANAGER = "busybox-mdev"

ANGSTROM_EXTRA_INSTALL ?= ""
IMAGE_INSTALL = "task-base-extended task-opie-base task-opie-base-applets \
		    task-opie-base-inputmethods task-opie-base-apps \
		    task-opie-base-settings task-opie-base-decorations \
		    task-opie-base-styles task-opie-base-pim \
		    task-opie-extra-settings \
  ${@base_contains("COMBINED_FEATURES", "bluetooth", "task-opie-bluetooth", "",d)} \
  ${@base_contains("COMBINED_FEATURES", "irda", "task-opie-irda", "",d)} \
                    ${ANGSTROM_EXTRA_INSTALL} "

# create /etc/timestamp from build date
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

inherit image
