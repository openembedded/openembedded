include hostap-modules.inc
PROVIDES = "virtual/kernel-hostap hostap-conf"
PR = "r4"

SRC_URI += "file://kernel_updates.patch;patch=1"
