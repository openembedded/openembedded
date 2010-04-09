require cups14.inc

SRC_URI += "file://use_echo_only_in_init.patch;patch=1 \
		    file://skip_tools.patch;patch=1 \
		    file://configure.patch;patch=1 \
			"

SRC_URI[archive.md5sum] = "e70b1c3f60143d7310c1d74c111a21ab"
SRC_URI[archive.sha256sum] = "47a559b1c50192b94479ae7dab132ea0008727045d4993501cf0a6df0c64db97"

PR = "r2"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " --disable-gssapi --disable-largefile --enable-debug --disable-relro "
