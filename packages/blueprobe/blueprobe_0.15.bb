SECTION = "base"
LICENSE = "GPL"
inherit gpe

PR = "r2"

SRC_URI += "file://hx4700.patch;patch=1 \
		  file://h6300.patch;patch=1"
