require libx11_${PV}.bb

EXTRA_OECONF += "--disable-xcms"

SRC_URI += " file://makekeys-update.patch"

PR = "${INC_PR}.0"
