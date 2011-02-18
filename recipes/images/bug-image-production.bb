# Copyright (C) 2008 Bug Labs, Inc
# Based on poky-image-sato.bb from Open Hand, Ltd.
#
# Image that defines BUG R1.4 production rootfs image.
#

PR = "r11"

DEPENDS = "task-bug"
IMAGE_FEATURES += "apps-console-core apps-x11-sato ${X11_IMAGE_FEATURES}"

inherit bug-image

# These are the base system recipes
IMAGE_INSTALL += "task-base-extended task-bug task-bug-java-osgi task-bug-audio task-bug-x11 task-bug-devlangs task-bug-network bash-sh task-bug-debug"
