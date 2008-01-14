IMAGE_LINGUAS = ""

DEPENDS = "${MACHINE_TASK_PROVIDER} task-opie"

IMAGE_INSTALL = "${MACHINE_TASK_PROVIDER} task-opie-base task-opie-base-applets \
		    task-opie-base-inputmethods task-opie-base-apps \
		    task-opie-base-settings task-opie-base-decorations \
		    task-opie-base-styles task-opie-base-pim \
		    task-opie-extra-settings \
		    task-opie-bluetooth task-opie-irda "

# create /etc/timestamp from build date
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

inherit image
