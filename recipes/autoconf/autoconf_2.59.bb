require autoconf.inc

PR = "${INC_PR}.0"

SRC_URI += "file://autoreconf-include.patch \
	   file://autoreconf-exclude.patch \
	   file://autoreconf-foreign.patch \
	   file://autoreconf-gnuconfigize.patch \
	   file://autoconf259-update-configscripts.patch \
	   file://autoheader-nonfatal-warnings.patch \
	   file://sizeof_types.patch \
	   file://autoconf-x.patch \
	   file://autoconf-sh.patch"

SRC_URI[autoconf.md5sum] = "1ee40f7a676b3cfdc0e3f7cd81551b5f"
SRC_URI[autoconf.sha256sum] = "f0cde70a8f135098a6a3e85869f2e1cc3f141beea766fa3d6636e086cd8b90a7"
