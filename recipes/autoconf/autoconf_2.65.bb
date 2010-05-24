require autoconf.inc

PR = "${INC_PR}.0"

SRC_URI += "file://autoreconf-exclude.patch;apply=yes \
	    file://autoreconf-foreign.patch;apply=yes \
	    file://autoheader-nonfatal-warnings.patch;apply=yes \
	    file://autoreconf-gnuconfigize.patch;apply=yes \
	    file://config-site.patch;apply=yes"

SRC_URI_append_virtclass-native = " file://fix_path_xtra.patch;apply=yes"

SRC_URI[autoconf.md5sum] = "a6de1cc6434cd64038b0a0ae4e252b33"
SRC_URI[autoconf.sha256sum] = "db11944057f3faf229ff5d6ce3fcd819f565455c152b72cec17ebc1cbb80136b"

