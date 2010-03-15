require orc.inc

PR = "r1"

SRC_URI[orc.md5sum] = "9b2e7030c8df8a0d371115869fe5685a"
SRC_URI[orc.sha256sum] = "4c0266d81da67fef0b2abd5e624a9ab0db5de04eb23c3ab24e22f5f9ceeefbfe"

SRC_URI += "file://03_orcutils.patch;patch=1 \
	file://99_autoreconf.patch;patch=1"


