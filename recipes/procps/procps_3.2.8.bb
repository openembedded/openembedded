require procps.inc

PR = "${INC_PR}.1"

SRC_URI += "file://procmodule.patch;patch=1 \
            file://psmodule.patch;patch=1 \
	    file://linux-limits.patch;patch=1 \
	    file://60_linux_version_init.dpatch;patch=1 \
	    "

SRC_URI[tarball.md5sum] = "9532714b6846013ca9898984ba4cd7e0"
SRC_URI[tarball.sha256sum] = "11ed68d8a4433b91cd833deb714a3aa849c02aea738c42e6b4557982419c1535"
