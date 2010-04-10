require mdadm.inc
PR = "r3"

SRC_URI += " file://build_flags.patch;patch=1 "

SRC_URI[mdadm-1.12.0.md5sum] = "736705240e918294740929518477fc6f"
SRC_URI[mdadm-1.12.0.sha256sum] = "22831449225cc39948b187c9e3bd89ba12d5c8abee18b2d0242da883cb7d9490"
