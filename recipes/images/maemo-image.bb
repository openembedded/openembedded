#
# Meta package for maemo based system image
#

GUI_MACHINE_CLASS ?= "none"

MAEMO_EXTRA_DEPENDS = "scap dosfstools"
MAEMO_EXTRA_INSTALL = "osso-af-services osso-af-base-apps scap dosfstools"

XSERVER ?= "xserver-kdrive-omap"

DEPENDS = "${MACHINE_TASK_PROVIDER} \
	   meta-maemo \
	   ${MAEMO_EXTRA_DEPENDS}"

IMAGE_INSTALL = "${MACHINE_TASK_PROVIDER} maemo-task-base maemo-task-theme \
	               maemo-task-apps ${MAEMO_EXTRA_INSTALL} \
		       ${XSERVER}"

inherit image
