require autoconf.inc

PR = "${INC_PR}.0"

SRC_URI += "file://autoreconf-include.patch;patch=1 \
	   file://autoreconf-exclude.patch;patch=1 \
	   file://autoreconf-foreign.patch;patch=1 \
	   file://autoreconf-gnuconfigize.patch;patch=1 \
	   file://autoconf259-update-configscripts.patch;patch=1 \
	   file://autoheader-nonfatal-warnings.patch;patch=1 \
	   file://sizeof_types.patch;patch=1 \
	   file://autoconf-x.patch;patch=1 \
	   file://autoconf-sh.patch;patch=1"

SRC_URI[autoconf.md5sum] = "1ee40f7a676b3cfdc0e3f7cd81551b5f"
SRC_URI[autoconf.sha256sum] = "f0cde70a8f135098a6a3e85869f2e1cc3f141beea766fa3d6636e086cd8b90a7"
