require autoconf.inc

PR = "${INC_PR}.0"

SRC_URI += "file://autoreconf-include.patch;apply=yes \
	   file://autoreconf-exclude.patch;apply=yes \
	   file://autoreconf-foreign.patch;apply=yes \
	   file://autoreconf-gnuconfigize.patch;apply=yes \
	   file://autoconf259-update-configscripts.patch;apply=yes \
	   file://autoheader-nonfatal-warnings.patch;apply=yes \
	   file://sizeof_types.patch;apply=yes \
	   file://autoconf-x.patch;apply=yes \
	   file://autoconf-sh.patch;apply=yes"

SRC_URI[autoconf.md5sum] = "1ee40f7a676b3cfdc0e3f7cd81551b5f"
SRC_URI[autoconf.sha256sum] = "f0cde70a8f135098a6a3e85869f2e1cc3f141beea766fa3d6636e086cd8b90a7"
