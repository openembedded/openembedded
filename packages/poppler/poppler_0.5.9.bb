require poppler.inc

FILE_PR = "r1"

SRC_URI += "file://fix-splash.patch;patch=1"
EXTRA_OECONF_append = " --disable-abiword-output "

