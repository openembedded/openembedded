require dropbear.inc
PR = "r0"

SRC_URI += "file://no-host-lookup.patch;patch=1"

DEFAULT_PREFERENCE = "-1"


SRC_URI[md5sum] = "a1fc7adf601bca53330a792a9c873439"
SRC_URI[sha256sum] = "8c7b727a4c9066e90a14f7f01c47cab698afb5a854ffa0404da162d4286f04c1"
