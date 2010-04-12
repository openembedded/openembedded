LICENSE = "GPL"
SECTION = "gpe"
inherit gpe

DEPENDS = "virtual/libx11 esound"

SRC_URI += "file://makefile-breakage.patch;patch=1 \
	    file://makefile-fix.patch;patch=1"

SRC_URI[md5sum] = "b9abca6437f13c4fc5bbb244738de9ea"
SRC_URI[sha256sum] = "07c91f5433d7c6c44c54640e9f5b65addedaf0eec5c5705175608404bee6de37"
