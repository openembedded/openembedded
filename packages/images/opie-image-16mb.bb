IMAGE_LINGUAS = ""

DEPENDS = "${MACHINE_TASK_PROVIDER} task-opie-16mb"

IMAGE_INSTALL = "task-boot \
                    ipkg ipkg-collateral \
                    dropbear \
                    task-opie-16mb-base \
                    task-opie-16mb-applets \
                    task-opie-16mb-inputmethods \
                    task-opie-16mb-settings \
                    task-opie-16mb-apps \
                    task-opie-16mb-pim \
		    task-opie-irda"

# create /etc/timestamp from build date
IMAGE_PREPROCESS_COMMAND = "merge_feeds; create_etc_timestamp"

inherit image
